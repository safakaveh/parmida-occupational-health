package com.parmida.usermanagment.service.impl;

import com.parmida.usermanagment.dto.FullInfoUserDto;
import com.parmida.usermanagment.dto.LoginDto;
import com.parmida.usermanagment.mapper.LoginMapper;
import com.parmida.usermanagment.model.LoginEntity;
import com.parmida.usermanagment.model.RelLoginGroupEntity;
import com.parmida.usermanagment.repository.LoginRepo;
import com.parmida.usermanagment.repository.RelLoginGroupRepo;
import com.parmida.usermanagment.service.CreateUserService;
import com.parmida.usermanagment.service.ManipulateUserService;
import com.parmida.usermanagment.service.exception.CreateUserException;
import com.parmida.usermanagment.service.exception.CreateUserException.CreateUserExceptionList;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Named("CreateUserService")
public class CreateUserServiceImpl implements CreateUserService {

	@Inject
	private LoginRepo loginRepo;

	@Inject
	private RelLoginGroupRepo relLoginGroupRepo;

	@Inject
	private LoginMapper loginMapper;

	@Inject
	@Named("ManipulateUserService")
	private ManipulateUserService createUser;

	@Override
	@Transactional
	public FullInfoUserDto create(FullInfoUserDto userDto, long loginId) {

		LoginEntity login = loginRepo.findByIdOptional(loginId)
				.orElseThrow(() -> new CreateUserException(CreateUserExceptionList.LOGIN_ID_NOT_FOUND));

		RelLoginGroupEntity relLoginGroupCurrent = relLoginGroupRepo.find(login.getUser().getId())
				.orElseThrow(() -> new CreateUserException(CreateUserExceptionList.LOGIN_ID_NOT_FOUND));

		String groupName = relLoginGroupCurrent.getGroup().getName().equals("admin") ? userDto.getGroupName()
				: relLoginGroupCurrent.getGroup().getName();

		LoginDto loginDto = loginMapper.toDTO(login);
		createUser.create(loginDto.getUser(), userDto.getUser().getFirstname(), userDto.getUser().getLastname(),
				userDto.getUser().getEmail(), userDto.getUser().getValidEmail(), userDto.getUser().getCellphone(),
				userDto.getUser().getValidCellphone(), userDto.getUser().getDescription(), userDto.getUser().getPhoto(),
				userDto.isActive(), userDto.getPassword(), groupName);

		return new FullInfoUserDto(userDto.getUser(), "*******", userDto.getGroupName(), userDto.isActive());
	}

}
