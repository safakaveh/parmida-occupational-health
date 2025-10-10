package com.parmida.usermanagment.service;

import java.util.List;

import com.parmida.usermanagment.dto.FullInfoUserDto;
import com.parmida.usermanagment.dto.GroupDto;
import com.parmida.usermanagment.dto.LoginDto;
import com.parmida.usermanagment.dto.RelLoginGroupDto;
import com.parmida.usermanagment.dto.UserDto;

public interface ManipulateUserService {
	public RelLoginGroupDto create(UserDto parent, String firstname, String lastname, String email, Boolean validEmail,
			String cellphone, Boolean validCellphone, String description, String photo, Boolean isActive,
			String strPassword, String groupName);

	public RelLoginGroupDto create(UserDto user, String password, String groupName, Boolean active);

	public RelLoginGroupDto update(UserDto parent, long userId, String firstname, String lastname, String email,
			Boolean validEmail, String cellphone, Boolean validCellphone, String description, String photo,
			Boolean isActive, String strPassword, String groupName);

	public RelLoginGroupDto update(UserDto user, String password, String groupName, Boolean active);

	public LoginDto updateUserActivation(long userid, Boolean active);

	public LoginDto delete(long userId);

	public List<FullInfoUserDto> getFullInfoUsersDto(int pageIndex, int pageSize, String sortBy, String order);

	public List<FullInfoUserDto> getFullInfoUsersDto(long parentUserId, int pageIndex, int pageSize, String sortBy,
			String order);

	public List<FullInfoUserDto> getFullTextSearch(String text, int pageIndex, int pageSize, String sortBy,
			String order);

	public List<FullInfoUserDto> getFullTextSearch(String text, long userParentId, int pageIndex, int pageSize,
			String sortBy, String order);

	public long getUserCount();

	public long getGroupCount();

	public GroupDto saveGroup(GroupDto groupDto);

}
