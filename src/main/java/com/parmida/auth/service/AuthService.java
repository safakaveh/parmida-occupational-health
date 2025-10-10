package com.parmida.auth.service;

import com.parmida.auth.dto.RefreshTokenDto.RefreshToken;

public interface AuthService {
	public String login(String auth);

	public String login(String auth, String uuid);

	public String generateAccessToken(long userID);

	public RefreshToken generateRefreshToken(long userID);

	public RefreshToken generateRefreshToken(String basicAuth);

	public RefreshToken generateRefreshToken(String auth, String uuid);

	public String generateAccessToken(Long userId, String uuid);

	public RefreshToken generateRefreshToken(Long userId, String uuid);

}
