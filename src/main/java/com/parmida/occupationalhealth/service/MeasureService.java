package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.MeasureDto;
import com.parmida.occupationalhealth.mapper.MeasureMapper;
import com.parmida.occupationalhealth.model.MeasureEntity;
import com.parmida.occupationalhealth.repository.MeasureRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MeasureService {
	@Inject
	private MeasureRepo measureRepo;
	
	@Inject
	private MeasureMapper measureMapper;

	public MeasureDto save(MeasureDto measure) {
		MeasureEntity entity = measureMapper.toEntity(measure);
		measureRepo.persist(entity);
		MeasureDto dto = measureMapper.toDTO(entity);
		return dto;

	}

}
