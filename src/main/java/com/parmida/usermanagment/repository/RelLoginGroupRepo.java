package com.parmida.usermanagment.repository;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.parmida.usermanagment.model.RelLoginGroupEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class RelLoginGroupRepo implements PanacheRepository<RelLoginGroupEntity>, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	public Optional<RelLoginGroupEntity> find(long userId) {
		final String QUERY_NAME = "#RelLoginGroup.find(userId)";
		final Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return find(QUERY_NAME, params).singleResultOptional();
	}

	public List<RelLoginGroupEntity> find(long parentUserId, int pageIndex, int pageSize) {
		final String QUERY_NAME = "#RelLoginGroup.find(parentUserId):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("parentUserId", parentUserId);
		return find(QUERY_NAME, params).page(pageIndex, pageSize).list();
	}

	public List<RelLoginGroupEntity> fullTextSearch(String text, int pageIndex, int pageSize) {
		final String QUERY_NAME = "#RelLoginGroup.fullTextSearch(text):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("text", "%" + text + "%");
		return find(QUERY_NAME, params).page(pageIndex, pageSize).list();
	}

	public List<RelLoginGroupEntity> fullTextSearch(String text, long userParentId, int pageIndex, int pageSize) {
		final String QUERY_NAME = "#RelLoginGroup.fullTextSearch(text,userParentId):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("userParentId", userParentId);
		params.put("text", "%" + text + "%");
		return find(QUERY_NAME, params).page(pageIndex, pageSize).list();
	}

	public List<RelLoginGroupEntity> fullTextSearch(String text, String groupName, int pageIndex, int pageSize)
			throws Exception {
		final String QUERY_NAME = "#RelLoginGroup.fullTextSearch(text,groupName):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		params.put("text", "%" + text + "%");
		return find(QUERY_NAME, params).page(pageIndex, pageSize).list();
	}

	public List<RelLoginGroupEntity> fullTextSearch(String text, String groupName, boolean active, int pageIndex,
			int pageSize) {
		final String QUERY_NAME = "#RelLoginGroup.fullTextSearch(text,groupName,active):List";
		final Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		params.put("active", active);
		params.put("text", "%" + text + "%");
		return find(QUERY_NAME, params).page(pageIndex, pageSize).list();
	}

}
