package com.parmida.usermanagment.repository;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.parmida.usermanagment.model.GroupEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class GroupRepo implements PanacheRepository<GroupEntity>, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	public Optional<GroupEntity> find(String groupName) {
		final String QUERY_NAME = "#Group.find(groupName)";
		final Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		return find(QUERY_NAME, params).singleResultOptional();
	}

	public List<GroupEntity> find(long loginId) {
		final String QUERY_NAME = "#Group.find(loginId):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return find(QUERY_NAME, params).list();
	}

	public long count(long loginId) {
		final String QUERY_NAME = "#Group.find(loginId):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return find(QUERY_NAME, params).count();
	}

	public List<GroupEntity> find(long loginId, final int pageIndex, final int pageSize) {
		final String QUERY_NAME = "#Group.find(loginId):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return find(QUERY_NAME, params).page(pageIndex, pageSize).list();
	}
}
