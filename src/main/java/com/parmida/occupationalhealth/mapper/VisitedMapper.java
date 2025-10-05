package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.RelVisitedMedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.dto.VisitedDto;
import com.parmida.occupationalhealth.model.RelVisitedMedicalCheckUpseaseEntity;
import com.parmida.occupationalhealth.model.VisitedEntity;

import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class VisitedMapper implements MainMapper<VisitedDto, VisitedEntity> {
	@Override
	public Class<VisitedDto> getDtoClass() {
		return VisitedDto.class;
	}

	@Override
	public Class<VisitedEntity> getEntityClass() {
		return VisitedEntity.class;
	}


}
