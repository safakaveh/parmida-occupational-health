package com.parmida.auth.repository;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.parmida.usermanagment.model.GroupEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RefreshTokenRepo implements PanacheRepository<GroupEntity>, Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	public Optional<GroupEntity> find(String jtiUUID, boolean active) {
		final String QUERY_NAME = "#RefreshToken.find(jtiUUID,active)";
		final Map<String, Object> params = new HashMap<>();
		params.put("jtiUUID", jtiUUID);
		params.put("active", active);
		return find(QUERY_NAME, params).singleResultOptional();
	}

	public Optional<GroupEntity> find(String jtiUUID) {
		return find(jtiUUID, true);
	}

}
