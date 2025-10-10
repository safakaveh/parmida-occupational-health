package com.parmida.usermanagment.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.JsonbBuilder;

@RegisterForReflection
public class FullInfoUserDto extends MainDto {

	public static record FullInfoUser(UserDto user, String password, String groupName, boolean active)
			implements RecordDto {
		public static final FullInfoUser fromString(String json) {
			return JsonbBuilder.create().fromJson(json, FullInfoUser.class);
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	private UserDto user;

	private String password;

	private String groupName;

	private boolean active;

	public FullInfoUserDto() {
		super();
	}

	public FullInfoUserDto(UserDto user, String password, String groupName, boolean active) {
		super();
		this.user = user;
		this.password = password;
		this.groupName = groupName;
		this.active = active;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@SuppressWarnings("unchecked")
	@Override
	public FullInfoUser getRecord() {
		return new FullInfoUser(user, password, groupName, active);
	}
}
