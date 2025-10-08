package com.parmida.occupationalhealth.repository;

import com.parmida.occupationalhealth.model.MeasureEntity;
import com.parmida.occupationalhealth.model.OrganizationEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class MeasureRepo implements PanacheRepository<MeasureEntity > {

}
