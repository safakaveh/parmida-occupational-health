package com.parmida.usermanagment.repository;

import java.io.Serial;
import java.io.Serializable;

import com.parmida.usermanagment.model.PasswordEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class PasswordRepo implements PanacheRepository<PasswordEntity>, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
}