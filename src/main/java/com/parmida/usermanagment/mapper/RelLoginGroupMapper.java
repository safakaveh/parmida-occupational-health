package com.parmida.usermanagment.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.usermanagment.dto.RelLoginGroupDto;
import com.parmida.usermanagment.model.RelLoginGroupEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelLoginGroupMapper implements MainMapper<RelLoginGroupDto, RelLoginGroupEntity> {

	@Override
	public Class<RelLoginGroupDto> getDtoClass() {
		return RelLoginGroupDto.class;
	}

	@Override
	public Class<RelLoginGroupEntity> getEntityClass() {
		return RelLoginGroupEntity.class;
	}

}
