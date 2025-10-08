package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.VisitedDto;
import com.parmida.occupationalhealth.mapper.VisitedMapper;
import com.parmida.occupationalhealth.model.VisitedEntity;
import com.parmida.occupationalhealth.repository.VisitedRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VisitedService {
	@Inject
	private VisitedRepo visitedRepo;
	
	@Inject
	private VisitedMapper visitedMapper;

	public VisitedDto save(VisitedDto visited) {
		VisitedEntity entity = visitedMapper.toEntity(visited);
		visitedRepo.persist(entity);
		VisitedDto dto = visitedMapper.toDTO(entity);
		return dto;

	}

}
