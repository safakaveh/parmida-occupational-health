package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.mapper.OrganizationMapper;
import com.parmida.occupationalhealth.model.OrganizationEntity;
import com.parmida.occupationalhealth.repository.OrganizationRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OrganizationService {

	@Inject
	private OrganizationRepo organizationRepo;
	
	@Inject
	private OrganizationMapper organizationMapper;

	public OrganizationDto save(OrganizationDto organizhation) {
		OrganizationEntity entity = organizationMapper.toEntity(organizhation);
		organizationRepo.persist(entity);
		OrganizationDto dto = organizationMapper.toDTO(entity);
		return dto;

	}

}
