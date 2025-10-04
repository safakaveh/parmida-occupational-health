package com.parmida.common.mapper;

import java.util.List;

import com.parmida.common.dto.MainDto;
import com.parmida.common.model.MainEntity;

import jakarta.json.bind.JsonbBuilder;

public abstract interface MainMapper<D extends MainDto, E extends MainEntity> {
	Class<D> getDtoClass();

	Class<E> getEntityClass();

	default D toDTO(E entity) {
		final String jsonEntity = JsonbBuilder.create().toJson(entity);
		return JsonbBuilder.create().fromJson(jsonEntity, getDtoClass());
	}

	default E toEntity(D dto) {
		final String jsonDTO = JsonbBuilder.create().toJson(dto);
		return JsonbBuilder.create().fromJson(jsonDTO, getEntityClass());
	}

	default List<D> toDTO(List<E> entities) {
		return entities.stream().map(this::toDTO).toList();
	}

	default List<E> toEntity(List<D> dtos) {
		return dtos.stream().map(this::toEntity).toList();
	}
}