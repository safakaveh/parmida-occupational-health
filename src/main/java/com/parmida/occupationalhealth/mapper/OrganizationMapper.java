package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.model.OrganizationEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrganizationMapper implements MainMapper<OrganizationDto, OrganizationEntity> {

	@Override
	public Class<OrganizationDto> getDtoClass() {
		return OrganizationDto.class;
	}

	@Override
	public Class<OrganizationEntity> getEntityClass() {
		return OrganizationEntity.class;
	}

}