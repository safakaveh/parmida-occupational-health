package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.RelVisitedJobDto;
import com.parmida.occupationalhealth.dto.RelVisitedMedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.model.RelVisitedJobEntity;
import com.parmida.occupationalhealth.model.RelVisitedMedicalCheckUpseaseEntity;

import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class RelVisitedMedicalCheckUpseaseMapper implements MainMapper<RelVisitedMedicalCheckUpseaseDto,RelVisitedMedicalCheckUpseaseEntity > {
	@Override
	public Class<RelVisitedMedicalCheckUpseaseDto> getDtoClass() {
		return RelVisitedMedicalCheckUpseaseDto.class;
	}

	@Override
	public Class<RelVisitedMedicalCheckUpseaseEntity> getEntityClass() {
		return RelVisitedMedicalCheckUpseaseEntity.class;
	}



}
