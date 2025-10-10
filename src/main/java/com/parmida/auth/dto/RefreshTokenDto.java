package com.parmida.auth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import jakarta.json.bind.JsonbBuilder;

public class RefreshTokenDto extends MainDto {

	public static record RefreshToken(Long createdAt, Integer maxAge, Boolean active, Long userId, String jtiUUID)
			implements RecordDto {

		public static final RefreshToken fromString(String json) {
			return JsonbBuilder.create().fromJson(json, RefreshToken.class);
		}

	}

	@Serial
	private static final long serialVersionUID = 1L;

	private Long createdAt;

	private Integer maxAge;

	private Boolean active;

	private Long userId;

	private String jtiUUID;

	public RefreshTokenDto() {
		super();
	}

	public RefreshTokenDto(Long createdAt, Integer maxAge, Boolean active, Long userId, String jtiUUID) {
		this.createdAt = createdAt;
		this.maxAge = maxAge;
		this.active = active;
		this.userId = userId;
		this.jtiUUID = jtiUUID;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getJtiUUID() {
		return jtiUUID;
	}

	public void setJtiUUID(String jtiUUID) {
		this.jtiUUID = jtiUUID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RefreshToken getRecord() {
		return new RefreshToken(createdAt, maxAge, active, userId, jtiUUID);
	}

}
