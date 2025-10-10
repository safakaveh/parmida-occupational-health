package com.parmida.usermanagment.repository;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.parmida.common.utils.PasswordTools;
import com.parmida.usermanagment.model.LoginEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class LoginRepo implements PanacheRepository<LoginEntity>, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	public Optional<LoginEntity> find(String username, String password) {
		final String hashPassword = PasswordTools.getHash(password);
		final String QUERY_NAME = "#Login.find(username,password)";
		final Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", hashPassword);
		return find(QUERY_NAME, params).singleResultOptional();
	}

	public Optional<LoginEntity> find(String username) {
		final String QUERY_NAME = "#Login.find(username)";
		final Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		return find(QUERY_NAME, params).singleResultOptional();
	}

	public Optional<LoginEntity> find(Long userId) {
		final String QUERY_NAME = "#Login.find(userId)";
		final Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return find(QUERY_NAME, params).singleResultOptional();
	}

}
