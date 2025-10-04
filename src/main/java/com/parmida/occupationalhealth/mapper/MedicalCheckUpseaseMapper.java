package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.MedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.model.MedicalCheckupseaseEntity;

public class MedicalCheckUpseaseMapper implements MainMapper<MedicalCheckUpseaseDto, MedicalCheckupseaseEntity> {

	@Override
	public Class<MedicalCheckUpseaseDto> getDtoClass() {
		return MedicalCheckUpseaseDto.class;
	}

	@Override
	public Class<MedicalCheckupseaseEntity> getEntityClass() {
		return MedicalCheckupseaseEntity.class;
	}

}
