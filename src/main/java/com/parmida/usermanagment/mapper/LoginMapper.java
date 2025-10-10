package com.parmida.usermanagment.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.usermanagment.dto.LoginDto;
import com.parmida.usermanagment.model.LoginEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoginMapper implements MainMapper<LoginDto, LoginEntity> {

	@Override
	public Class<LoginDto> getDtoClass() {
		return LoginDto.class;
	}

	@Override
	public Class<LoginEntity> getEntityClass() {
		return LoginEntity.class;
	}

}
