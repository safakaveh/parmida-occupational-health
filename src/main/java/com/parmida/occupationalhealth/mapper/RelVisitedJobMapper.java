package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.dto.RelVisitedJobDto;
import com.parmida.occupationalhealth.model.OrganizationEntity;
import com.parmida.occupationalhealth.model.RelVisitedJobEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelVisitedJobMapper implements MainMapper<RelVisitedJobDto , RelVisitedJobEntity> {
	@Override
	public Class<RelVisitedJobDto> getDtoClass() {
		return RelVisitedJobDto.class;
	}

	@Override
	public Class<RelVisitedJobEntity> getEntityClass() {
		return RelVisitedJobEntity.class;
	}


}
