package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.RelVisitedMedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.mapper.RelVisitedMedicalCheckUpseaseMapper;
import com.parmida.occupationalhealth.model.RelVisitedMedicalCheckUpseaseEntity;
import com.parmida.occupationalhealth.repository.RelVisitedMedicalCheckUpseaseRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RelVisitedMedicalCheckUpseaseService {

	@Inject
	private RelVisitedMedicalCheckUpseaseRepo relVisitedMedicalCheckUpseaseRepo;
	
	@Inject
	private RelVisitedMedicalCheckUpseaseMapper relVisitedMedicalCheckUpseaseMapper;

	public RelVisitedMedicalCheckUpseaseDto save(RelVisitedMedicalCheckUpseaseDto relVisitedMedicalCheckUpsease) {
		RelVisitedMedicalCheckUpseaseEntity entity = relVisitedMedicalCheckUpseaseMapper
				.toEntity(relVisitedMedicalCheckUpsease);
		relVisitedMedicalCheckUpseaseRepo.persist(entity);
		RelVisitedMedicalCheckUpseaseDto dto = relVisitedMedicalCheckUpseaseMapper.toDTO(entity);
		return dto;

	}

}
