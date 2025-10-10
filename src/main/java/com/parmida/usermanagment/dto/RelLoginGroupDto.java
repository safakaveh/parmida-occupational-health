package com.parmida.usermanagment.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.JsonbBuilder;

@RegisterForReflection
public class RelLoginGroupDto extends MainDto {
	public static record Login(Long id, Long version, Long createOn, Long updateOn, Boolean deleted, LoginDto login,
			GroupDto group) implements RecordDto {
		public static final Login fromString(String json) {
			return JsonbBuilder.create().fromJson(json, Login.class);
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	private LoginDto login;

	private GroupDto group;

	public RelLoginGroupDto() {
		super();
	}

	public LoginDto getLogin() {
		return login;
	}

	public void setLogin(LoginDto login) {
		this.login = login;
	}

	public GroupDto getGroup() {
		return group;
	}

	public void setGroup(GroupDto group) {
		this.group = group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Login getRecord() {
		return new Login(id, version, createOn, updateOn, deleted, login, group);
	}

}
