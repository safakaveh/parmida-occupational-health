package com.parmida.common.converter;

import java.util.ArrayList;
import java.util.List;

import com.parmida.common.dto.MainDto;
import com.parmida.common.model.MainEntity;

public abstract class MainConverter<D extends MainDto, E extends MainEntity> {
	private final Class<E> entityClass;
	private final Class<D> dtoClass;

	protected MainConverter(Class<D> dtoClass, Class<E> entityClass) {
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}

	public D entityToDto(E e) {
		String jsonStr = e.toString();
		return MainDto.fromString(jsonStr, dtoClass);
	}

	public E dtoToEntity(D d) {
		String jsonStr = d.toString();
		return MainEntity.fromString(jsonStr, entityClass);
	}

	public List<D> entityToDto(List<E> es) {
		List<D> result = new ArrayList<>();
		es.forEach(e -> result.add(entityToDto(e)));
		return result;
	}

	public List<E> dtoToEntity(List<D> ds) {
		List<E> result = new ArrayList<>();
		ds.forEach(d -> result.add(dtoToEntity(d)));
		return result;
	}

}
