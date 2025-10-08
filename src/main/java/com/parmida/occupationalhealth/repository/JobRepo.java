package com.parmida.occupationalhealth.repository;

import com.parmida.occupationalhealth.model.JobEntity;
import com.parmida.occupationalhealth.model.OrganizationEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class JobRepo implements PanacheRepository<JobEntity > {

}
