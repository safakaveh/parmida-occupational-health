package com.parmida.auth.token;

import java.util.Base64;
import java.util.UUID;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import com.parmida.auth.dto.RefreshTokenDto.RefreshToken;
import com.parmida.auth.token.exception.AccessTokenException;
import com.parmida.auth.token.exception.AccessTokenException.AccessTokenExceptionList;
import com.parmida.auth.token.exception.RefreshTokenIssuerException;
import com.parmida.auth.token.exception.RefreshTokenIssuerException.RefreshTokenIssuerExceptionList;
import com.parmida.usermanagment.model.LoginEntity;
import com.parmida.usermanagment.repository.LoginRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RefreshTokenIssuer {
	private static final Logger LOG = Logger.getLogger(RefreshTokenIssuer.class);

	@Inject
	@ConfigProperty(name = "refresh.token.timeout")
	private int refreshTimeout;

	@Inject
	@ConfigProperty(name = "smallrye.jwt.sign.key.location")
	private String privateKeyPath;

	@Inject
	private LoginRepo loginRepo;

	private String jti;

	public RefreshToken generateRefreshToken(Long userId) {
		try {
			if (jti == null || jti.isEmpty()) {
				jti = UUID.randomUUID().toString();
			}
			final long currentTimeSec = System.currentTimeMillis() / 1000;
			final int expireTimeSec = refreshTimeout * 60;
			return new RefreshToken(currentTimeSec, expireTimeSec, true, userId, jti);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.REFRESH_TOKEN_GENERATION_HAS_ERROR);
		}
	}

	public RefreshToken generateRefreshToken(String basicAuth) {
		LoginEntity login = getLogin(basicAuth);
		return generateRefreshToken(login.getUser().getId());
	}

	public RefreshToken generateRefreshTokenWithUUID(String auth, String uuid) {
		this.jti = uuid;
		return generateRefreshToken(auth);
	}

	public RefreshToken generateRefreshToken(String username, String password) {
		LoginEntity login = getLogin(username, password);
		return generateRefreshToken(login.getUser().getId());
	}

	public RefreshToken generateRefreshToken(Long userId, String uuid) {
		this.jti = uuid;
		return generateRefreshToken(userId);
	}

	private LoginEntity getLogin(String username, String password) {
		LoginEntity login = loginRepo.find(username, password).filter(LoginEntity::isActive)
				.orElseThrow(() -> new AccessTokenException(AccessTokenExceptionList.USERNAME_AND_PASSWORD_NOT_FOUND));

		if (login.getUser().getFirstname() == null && login.getUser().getLastname() == null) {
			login.getUser().setLastname("Not Set.");
		}
		return login;
	}

	private LoginEntity getLogin(String basicAuth) {
		byte[] decodeAuth0 = Base64.getDecoder().decode(basicAuth);
		String[] usernamePassword = new String(decodeAuth0).trim().split(":");
		return getLogin(usernamePassword[0], usernamePassword[1]);
	}

}