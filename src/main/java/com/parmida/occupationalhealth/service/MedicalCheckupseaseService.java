package com.parmida.occupationalhealth.service;

import com.parmida.occupationalhealth.dto.MedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.mapper.MedicalCheckUpseaseMapper;
import com.parmida.occupationalhealth.model.MedicalCheckupseaseEntity;
import com.parmida.occupationalhealth.repository.MedicalCheckupseaseRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MedicalCheckupseaseService {
	@Inject
	private MedicalCheckupseaseRepo medicalCheckupseaseRepo;
	
	@Inject
	private MedicalCheckUpseaseMapper medicalCheckUpseaseMapper;

	public MedicalCheckUpseaseDto save(MedicalCheckUpseaseDto medicalCheckUpsease) {
		MedicalCheckupseaseEntity entity = medicalCheckUpseaseMapper.toEntity(medicalCheckUpsease);
		medicalCheckupseaseRepo.persist(entity);
		MedicalCheckUpseaseDto dto = medicalCheckUpseaseMapper.toDTO(entity);
		return dto;

	}
}
