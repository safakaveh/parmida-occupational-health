package com.parmida.usermanagment.mapper;

import com.parmida.common.mapper.MainMapper;
import com.parmida.usermanagment.dto.UserDto;
import com.parmida.usermanagment.model.UserEntity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper implements MainMapper<UserDto, UserEntity> {

	@Override
	public Class<UserDto> getDtoClass() {
		return UserDto.class;
	}

	@Override
	public Class<UserEntity> getEntityClass() {
		return UserEntity.class;
	}

}
