package com.parmida.occupationalhealth.repository;

import com.parmida.occupationalhealth.model.MedicalCheckupseaseEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class MedicalCheckupseaseRepo implements PanacheRepository<MedicalCheckupseaseEntity> {

}
