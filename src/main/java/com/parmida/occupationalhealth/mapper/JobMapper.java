package com.parmida.occupationalhealth.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.occupationalhealth.dto.JobDto;
import com.parmida.occupationalhealth.model.JobEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JobMapper implements MainMapper<JobDto, JobEntity> {

	@Override
	public Class<JobDto> getDtoClass() {
		return JobDto.class;
	}

	@Override
	public Class<JobEntity> getEntityClass() {
		return JobEntity.class;
	}

}
