package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.MeasureDto;
import com.parmida.occupationalhealth.model.MeasureEntity;

import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class MeasureMapper implements MainMapper<MeasureDto, MeasureEntity> {

	@Override
	public Class<MeasureDto> getDtoClass() {
		return MeasureDto.class;
	}

	@Override
	public Class<MeasureEntity> getEntityClass() {
		return MeasureEntity.class;
	}

}
