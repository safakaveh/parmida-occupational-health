package com.parmida.auth.service.impl;

import com.parmida.auth.dto.RefreshTokenDto.RefreshToken;
import com.parmida.auth.service.AuthService;
import com.parmida.auth.token.AccessTokenIssuer;
import com.parmida.auth.token.RefreshTokenIssuer;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named("AuthService")
public class AuthServiceImpl implements AuthService {

	@Inject
	AccessTokenIssuer accessTokenIssuer;

	@Inject
	RefreshTokenIssuer refreshTokenIssuer;

	@Override
	public String login(String auth) {
		return accessTokenIssuer.generateJWT(auth);
	}

	@Override
	public String login(String auth, String uuid) {
		return accessTokenIssuer.generateJWTWithUUID(auth, uuid);
	}

	@Override
	public String generateAccessToken(long userID) {
		return accessTokenIssuer.generateJWT(userID);
	}

	@Override
	public String generateAccessToken(Long userId, String uuid) {
		return accessTokenIssuer.generateJWT(userId, uuid);
	}

	@Override
	public RefreshToken generateRefreshToken(long userID) {
		return refreshTokenIssuer.generateRefreshToken(userID);
	}

	@Override
	public RefreshToken generateRefreshToken(String basicAuth) {
		return refreshTokenIssuer.generateRefreshToken(basicAuth);
	}

	@Override
	public RefreshToken generateRefreshToken(String auth, String uuid) {
		return refreshTokenIssuer.generateRefreshTokenWithUUID(auth, uuid);
	}

	@Override
	public RefreshToken generateRefreshToken(Long userId, String uuid) {
		return refreshTokenIssuer.generateRefreshToken(userId, uuid);
	}

}
