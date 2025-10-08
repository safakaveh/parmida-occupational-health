package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.JobDto;
import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.mapper.JobMapper;
import com.parmida.occupationalhealth.mapper.OrganizationMapper;
import com.parmida.occupationalhealth.model.JobEntity;
import com.parmida.occupationalhealth.model.OrganizationEntity;
import com.parmida.occupationalhealth.repository.JobRepo;
import com.parmida.occupationalhealth.repository.OrganizationRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class JobService {
	@Inject
	private JobRepo jobRepo;
	@Inject
	private  JobMapper jobMapper;

	public JobDto  save(JobDto job) {
		JobEntity  entity = jobMapper.toEntity(job);
		jobRepo.persist(entity);
		JobDto dto = jobMapper.toDTO(entity);
		return dto;

	}

}
