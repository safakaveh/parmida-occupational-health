package com.parmida.usermanagment.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.parmida.usermanagment.model.UserEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class UserRepo implements PanacheRepository<UserEntity>, Serializable {

	private static final long serialVersionUID = 1L;

	public Optional<UserEntity> find(long loginId) {
		String QUERY_NAME = "#User.find(loginId)";
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return find(QUERY_NAME, params).singleResultOptional();
	}

	public long getUsersCount() {
		return findAll().count();
	}

	public List<UserEntity> find(long parentId, int pageIndex, int pageSize, String sortBy, String order) {
		String QUERY_NAME = "#User.find(parentId):List";
		Map<String, Object> params = new HashMap<>();
		params.put("parentId", parentId);
		sortBy = sortBy == null ? "id" : sortBy;
		return switch (order) {
		case "asc" -> find(QUERY_NAME, Sort.ascending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case "des" -> find(QUERY_NAME, Sort.descending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case null, default -> find(QUERY_NAME, params, params).page(pageIndex - 1, pageSize).list();
		};
	}

	public List<UserEntity> fullTextSearch(String text, String groupName, int pageIndex, int pageSize, String sortBy,
			String order) {
		String QUERY_NAME = "#User.fullTextSearch(text,groupName):List";
		Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		params.put("text", "%" + text + "%");
		sortBy = sortBy == null ? "id" : sortBy;
		return switch (order) {
		case "asc" -> find(QUERY_NAME, Sort.ascending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case "des" -> find(QUERY_NAME, Sort.descending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case null, default -> find(QUERY_NAME, params, params).page(pageIndex - 1, pageSize).list();
		};
	}

	public List<UserEntity> find(String groupName, long userParentId, int pageIndex, int pageSize, String sortBy,
			String order) {
		String QUERY_NAME = "#User.find(groupName,userParentId):List";
		Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		params.put("userParentId", userParentId);
		sortBy = sortBy == null ? "id" : sortBy;
		return switch (order) {
		case "asc" -> find(QUERY_NAME, Sort.ascending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case "des" -> find(QUERY_NAME, Sort.descending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case null, default -> find(QUERY_NAME, params, params).page(pageIndex - 1, pageSize).list();
		};
	}

	public long count(String groupName, long userParentId) {
		String QUERY_NAME = "#User.find(groupName,userParentId):List";
		Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		params.put("userParentId", userParentId);
		return find(QUERY_NAME, params).count();
	}

	public List<UserEntity> find(String groupName, int pageIndex, int pageSize, String sortBy, String order) {
		String QUERY_NAME = "#User.find(groupName):List";
		Map<String, Object> params = new HashMap<>();
		params.put("groupName", groupName);
		sortBy = sortBy == null ? "id" : sortBy;
		return switch (order) {
		case "asc" -> find(QUERY_NAME, Sort.ascending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case "des" -> find(QUERY_NAME, Sort.descending(sortBy), params).page(pageIndex - 1, pageSize).list();
		case null, default -> find(QUERY_NAME, params, params).page(pageIndex - 1, pageSize).list();
		};
	}
}