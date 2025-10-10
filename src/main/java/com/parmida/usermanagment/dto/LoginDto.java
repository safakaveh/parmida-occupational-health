package com.parmida.usermanagment.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;
import com.parmida.usermanagment.model.PasswordEntity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.JsonbBuilder;

@RegisterForReflection
public class LoginDto extends MainDto {
	public static record Login(Long id, Long version, Long createOn, Long updateOn, Boolean deleted, UserDto user,
			PasswordEntity password, Boolean active) implements RecordDto {
		public static final Login fromString(String json) {
			return JsonbBuilder.create().fromJson(json, Login.class);
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	private UserDto user;

	private PasswordEntity password;

	private Boolean active;

	public LoginDto() {
		super();
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public PasswordEntity getPassword() {
		return password;
	}

	public void setPassword(PasswordEntity password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Login getRecord() {
		return new Login(id, version, createOn, updateOn, deleted, user, password, active);
	}

}
