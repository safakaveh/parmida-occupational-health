package com.parmida.auth.token;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import com.parmida.auth.token.exception.AccessTokenException;
import com.parmida.auth.token.exception.AccessTokenException.AccessTokenExceptionList;
import com.parmida.common.converter.ConvertNumberUnicode;
import com.parmida.usermanagment.model.GroupEntity;
import com.parmida.usermanagment.model.LoginEntity;
import com.parmida.usermanagment.repository.GroupRepo;
import com.parmida.usermanagment.repository.LoginRepo;

import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AccessTokenIssuer {
	private static final Logger LOG = Logger.getLogger(AccessTokenIssuer.class);

	@Inject
	@ConfigProperty(name = "mp.jwt.verify.issuer")
	private String jwtIssuer;

	@Inject
	@ConfigProperty(name = "access.token.timeout")
	private int jwtTimeout;

	@Inject
	@ConfigProperty(name = "smallrye.jwt.sign.key.location")
	private String privateKeyPath;

	@Inject
	private GroupRepo groupRepo;

	@Inject
	private LoginRepo loginRepo;

	private String jti;

	public String generateJWT(String username, String password) {
		try {
			if (jti == null || jti.isEmpty()) {
				jti = UUID.randomUUID().toString();
			}
			LoginEntity login = getLogin(username, password);
			return generateJwt(login);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AccessTokenException(AccessTokenExceptionList.JWT_GENERATION_HAS_ERROR);
		}
	}

	public String generateJWT(long loginID) {
		try {
			if (jti == null || jti.isEmpty()) {
				jti = UUID.randomUUID().toString();
			}
			LoginEntity login = getLogin(loginID);
			return generateJwt(login);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AccessTokenException(AccessTokenExceptionList.JWT_GENERATION_HAS_ERROR);
		}
	}

	public String generateJWT(String basicAuth) {
		try {
			byte[] decodeAuth0 = Base64.getDecoder().decode(basicAuth);
			String[] usernamePassword = new String(decodeAuth0).trim().split(":");
			return generateJWT(usernamePassword[0], usernamePassword[1]);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AccessTokenException(AccessTokenExceptionList.JWT_GENERATION_HAS_ERROR);
		}
	}

	public String generateJWTWithUUID(String auth, String uuid) {
		this.jti = uuid;
		return generateJWT(auth);
	}

	public String generateJWT(Long userId, String uuid) {
		this.jti = uuid;
		return generateJWT(userId);
	}

	private String generateJwt(LoginEntity login)
			throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
		Set<String> groups = groupRepo.find(login.getId()).stream().map(GroupEntity::getName)
				.collect(Collectors.toSet());

		final long currentTimeSec = System.currentTimeMillis() / 1000;
		final long expireTimeSec = jwtTimeout * 60;
		PrivateKey privateKey = loadPrivateKey(privateKeyPath);
		// get login id with "^(.*?)- " regx
		return Jwt.subject(login.getId() + "-SUNECITY-JWT-TOKEN").issuer(jwtIssuer).issuedAt(currentTimeSec)
				.expiresAt(currentTimeSec + expireTimeSec)
				.upn(ConvertNumberUnicode.convertNo(login.getUser().getCellphone())).groups(groups).claim("jti", jti)
				.preferredUserName(ConvertNumberUnicode.convertNo(login.getUser().getEmail())).jws()
				.algorithm(SignatureAlgorithm.ES256).sign(privateKey);
	}

	private LoginEntity getLogin(String username, String password) {
		LoginEntity login = loginRepo.find(username, password).filter(LoginEntity::isActive)
				.orElseThrow(() -> new AccessTokenException(AccessTokenExceptionList.USERNAME_AND_PASSWORD_NOT_FOUND));

		if (login.getUser().getFirstname() == null && login.getUser().getLastname() == null) {
			login.getUser().setLastname("Not Set.");
		}
		return login;
	}

	private LoginEntity getLogin(long loginID) {
		LoginEntity login = loginRepo.find(loginID).filter(LoginEntity::isActive)
				.orElseThrow(() -> new AccessTokenException(AccessTokenExceptionList.USERNAME_AND_PASSWORD_NOT_FOUND));

		if (login.getUser().getFirstname() == null && login.getUser().getLastname() == null) {
			login.getUser().setLastname("Not Set.");
		}
		return login;
	}

	private PrivateKey loadPrivateKey(String path)
			throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		try (InputStream keyStream = getClass().getClassLoader().getResourceAsStream(path)) {
			if (keyStream == null) {
				throw new FileNotFoundException("Key file not found: " + path);
			}
			byte[] keyBytes = keyStream.readAllBytes();
			String pem = new String(keyBytes).replaceAll("-----BEGIN (.*)-----", "")
					.replaceAll("-----END (.*)-----", "").replaceAll("\\s", ""); // Remove newlines
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pem));
			return KeyFactory.getInstance("EC").generatePrivate(spec);
		}
	}

}