package com.parmida.usermanagment.service;

import com.parmida.usermanagment.dto.FullInfoUserDto;

public interface CreateUserService {

	FullInfoUserDto create(FullInfoUserDto userDto, long loginId);

}
