package com.parmida.occupationalhealth.repository;

import com.parmida.occupationalhealth.model.RelVisitedJobEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class RelVisitedJobRepo implements PanacheRepository<RelVisitedJobEntity>{

}
