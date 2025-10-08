package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.MeasureDto;
import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.mapper.MeasureMapper;
import com.parmida.occupationalhealth.mapper.OrganizationMapper;
import com.parmida.occupationalhealth.model.MeasureEntity;
import com.parmida.occupationalhealth.model.OrganizationEntity;
import com.parmida.occupationalhealth.repository.MeasureRepo;
import com.parmida.occupationalhealth.repository.OrganizationRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MeasureService {
	@Inject
	private MeasureRepo  measureRepo;
	@Inject
	private MeasureMapper measureMapper;

	public MeasureDto  save(MeasureDto measure) {
		MeasureEntity entity = measureMapper.toEntity(measure);
		measureRepo.persist(entity);
		MeasureDto dto = measureMapper.toDTO(entity);
		return dto;

	}


}
