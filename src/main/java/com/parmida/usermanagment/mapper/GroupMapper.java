package com.parmida.usermanagment.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.usermanagment.dto.GroupDto;
import com.parmida.usermanagment.model.GroupEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroupMapper implements MainMapper<GroupDto, GroupEntity> {

	@Override
	public Class<GroupDto> getDtoClass() {
		return GroupDto.class;
	}

	@Override
	public Class<GroupEntity> getEntityClass() {
		return GroupEntity.class;
	}

}
