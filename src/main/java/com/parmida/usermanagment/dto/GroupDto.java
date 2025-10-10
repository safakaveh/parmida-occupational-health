package com.parmida.usermanagment.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.JsonbBuilder;

@RegisterForReflection
public class GroupDto extends MainDto {
	public static record Group(Long id, Long version, Long createOn, Long updateOn, Boolean deleted, String name,
			String description) implements RecordDto {
		public static final Group fromString(String json) {
			return JsonbBuilder.create().fromJson(json, Group.class);
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	public GroupDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Group getRecord() {
		return new Group(id, version, createOn, updateOn, deleted, name, description);
	}

}
