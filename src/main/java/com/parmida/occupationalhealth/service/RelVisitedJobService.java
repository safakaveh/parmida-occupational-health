package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.dto.RelVisitedJobDto;
import com.parmida.occupationalhealth.mapper.OrganizationMapper;
import com.parmida.occupationalhealth.mapper.RelVisitedJobMapper;
import com.parmida.occupationalhealth.model.OrganizationEntity;
import com.parmida.occupationalhealth.model.RelVisitedJobEntity;
import com.parmida.occupationalhealth.repository.OrganizationRepo;
import com.parmida.occupationalhealth.repository.RelVisitedJobRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class RelVisitedJobService {
	@Inject
	private RelVisitedJobRepo  relVisitedJobRepo;
	@Inject
	private RelVisitedJobMapper  relVisitedJobMapper;

	public RelVisitedJobDto  save(RelVisitedJobDto RelVisitedJob) {
		RelVisitedJobEntity  entity = relVisitedJobMapper.toEntity(relVisitedJob);
		relVisitedJobRepo.persist(entity);
		RelVisitedJobDto dto = relVisitedJobMapper.toDTO(entity);
		return dto;

	}


}
