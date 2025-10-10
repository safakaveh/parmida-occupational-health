package com.parmida.auth.web.restapi;

import java.util.Set;
import java.util.UUID;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import com.parmida.auth.dto.RefreshTokenDto.RefreshToken;
import com.parmida.auth.service.AuthService;
import com.parmida.auth.token.exception.AccessTokenException;
import com.parmida.auth.token.exception.AccessTokenException.AccessTokenExceptionList;
import com.parmida.auth.token.exception.RefreshTokenIssuerException;
import com.parmida.auth.token.exception.RefreshTokenIssuerException.RefreshTokenIssuerExceptionList;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.NewCookie.SameSite;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@RequestScoped
public class AuthApi {
	@Inject
	@Claim(standard = Claims.jti)
	String jti;

	@Inject
	@Claim(standard = Claims.groups)
	Set<String> groups;

	@Inject
	@Named("AuthService")
	AuthService authService;

	@Inject
	@Named("DragonflyCacheService")
	CacheServeice cacheServeice;

	@Inject
	@ConfigProperty(name = "refresh.token.refresh.url")
	private String refreshTokenRefreshUrl;
	@Inject
	@ConfigProperty(name = "refresh.token.logout.url")
	private String refreshTokenLogoutUrl;

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(@Context HttpHeaders headers) {
		final String AUTHORIZATION_TYPE = "Basic ";
		String authHeader = headers.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authHeader == null || !authHeader.startsWith(AUTHORIZATION_TYPE)) {
			throw new AccessTokenException(AccessTokenExceptionList.AUTH_IS_EMPTY);
		}
		String basicLogin = authHeader.substring(AUTHORIZATION_TYPE.length());

		String uuid = UUID.randomUUID().toString();
		String accessToken = authService.login(basicLogin, uuid);
		RefreshToken refreshToken = authService.generateRefreshToken(basicLogin, uuid);

		// Save refresh token to cache.
		cacheServeice.insert("auth", refreshToken.jtiUUID(), refreshToken.json(), refreshToken.maxAge());

		NewCookie refreshCookieRefresh = new NewCookie.Builder("refresh_token").value(refreshToken.jtiUUID())
				.path(refreshTokenRefreshUrl).httpOnly(true).sameSite(SameSite.STRICT).secure(false)
				.maxAge(refreshToken.maxAge()).build();

		return Response.status(Status.OK).cookie(refreshCookieRefresh).entity(accessToken).build();
	}

	@POST
	@Path("/logout")
	@RolesAllowed({ "admin", "customer", "supporter", "device" })
	@Produces(MediaType.TEXT_PLAIN)
	public Response logout() {
		if (jti == null || jti.isEmpty()) {
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.REFRESH_TOKEN_NOT_FOUND);
		}

		UUID jtiUUID;
		try {
			jtiUUID = UUID.fromString(jti);
		} catch (Exception e) {
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.INVALID_UUID);
		}

		String refreshTokenJson = cacheServeice.read("auth", jtiUUID.toString());
		if (refreshTokenJson == null || refreshTokenJson.isEmpty()) {
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.REFRESH_TOKEN_NOT_FOUND);
		}

		RefreshToken refreshToken = RefreshToken.fromString(refreshTokenJson);

		// Delete old refresh token from cache.
		cacheServeice.remove("auth", refreshToken.jtiUUID());

		return Response.status(Status.OK).entity(true).build();
	}

	@POST
	@Path("/refresh")
	@Produces(MediaType.TEXT_PLAIN)
	public Response refreshToken(@CookieParam("refresh_token") String refreshTokenJti) {
		if (refreshTokenJti == null || refreshTokenJti.isEmpty()) {
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.REFRESH_TOKEN_NOT_FOUND);
		}

		UUID jtiUUID;
		try {
			jtiUUID = UUID.fromString(refreshTokenJti);
		} catch (Exception e) {
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.INVALID_UUID);
		}

		String refreshTokenJson = cacheServeice.read("auth", jtiUUID.toString());
		if (refreshTokenJson == null || refreshTokenJson.isEmpty()) {
			throw new RefreshTokenIssuerException(RefreshTokenIssuerExceptionList.REFRESH_TOKEN_NOT_FOUND);
		}

		RefreshToken refreshToken = RefreshToken.fromString(refreshTokenJson);

		String uuid = UUID.randomUUID().toString();
		String newAccessToken = authService.generateAccessToken(refreshToken.userId(), uuid);
		RefreshToken newRefreshToken = authService.generateRefreshToken(refreshToken.userId(), uuid);
		// Delete old refresh token from cache.
		cacheServeice.remove("auth", refreshToken.jtiUUID());
		// Save refresh token to cache.
		cacheServeice.insert("auth", newRefreshToken.jtiUUID(), newRefreshToken.json(), newRefreshToken.maxAge());

		NewCookie newRefreshCookieRefresh = new NewCookie.Builder("refresh_token").value(newRefreshToken.jtiUUID())
				.path(refreshTokenRefreshUrl).httpOnly(true).sameSite(SameSite.STRICT).secure(true)
				.maxAge(newRefreshToken.maxAge()).build();

		return Response.status(Status.OK).entity(newAccessToken).cookie(newRefreshCookieRefresh).build();
	}

	@GET
	@Path("/groups")
	@RolesAllowed({ "admin", "customer", "supporter", "device" })
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroups() {
		return Response.status(Status.OK).entity(groups).build();
	}

}
