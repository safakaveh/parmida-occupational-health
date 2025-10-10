package com.parmida.usermanagment.service.impl;

import java.util.List;

import com.parmida.usermanagment.dto.FullInfoUserDto;
import com.parmida.usermanagment.dto.GroupDto;
import com.parmida.usermanagment.dto.LoginDto;
import com.parmida.usermanagment.dto.RelLoginGroupDto;
import com.parmida.usermanagment.dto.UserDto;
import com.parmida.usermanagment.mapper.GroupMapper;
import com.parmida.usermanagment.mapper.LoginMapper;
import com.parmida.usermanagment.mapper.RelLoginGroupMapper;
import com.parmida.usermanagment.mapper.UserMapper;
import com.parmida.usermanagment.model.GroupEntity;
import com.parmida.usermanagment.model.LoginEntity;
import com.parmida.usermanagment.model.PasswordEntity;
import com.parmida.usermanagment.model.RelLoginGroupEntity;
import com.parmida.usermanagment.model.UserEntity;
import com.parmida.usermanagment.repository.GroupRepo;
import com.parmida.usermanagment.repository.LoginRepo;
import com.parmida.usermanagment.repository.RelLoginGroupRepo;
import com.parmida.usermanagment.repository.UserRepo;
import com.parmida.usermanagment.service.ManipulateUserService;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Named("ManipulateUserService")
public class ManipulateUserServiceImpl implements ManipulateUserService {
	@Inject
	private GroupRepo groupRepo;

	@Inject
	private UserRepo userRepo;

	@Inject
	private LoginRepo loginRepo;

	@Inject
	private RelLoginGroupRepo relLoginGroupRepo;

	@Inject
	private UserMapper userMapper;

	@Inject
	private RelLoginGroupMapper relLoginGroupMapper;

	@Inject
	private LoginMapper loginMapper;

	@Inject
	private GroupMapper groupMapper;

	@Override
	@Transactional
	public RelLoginGroupDto create(UserDto parent, String firstname, String lastname, String email, Boolean validEmail,
			String cellphone, Boolean validCellphone, String description, String photo, Boolean isActive,
			String strPassword, String groupName) {
		GroupEntity group = groupRepo.find(groupName).orElseThrow(() -> new RuntimeException("Group not found."));
		UserEntity user = new UserEntity(userMapper.toEntity(parent), firstname, lastname, email, validEmail, cellphone,
				validCellphone, description, photo);

		try {
			userRepo.persist(user);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		PasswordEntity password = new PasswordEntity(strPassword);
		LoginEntity login = new LoginEntity(user, password, isActive);
		try {
			loginRepo.persist(login);
		} catch (Exception e) {
			userRepo.delete(user);
			throw new RuntimeException(e.getMessage());
		}

		RelLoginGroupEntity rlg = new RelLoginGroupEntity(login, group);
		relLoginGroupRepo.persist(rlg);
		return relLoginGroupMapper.toDTO(rlg);
	}

	@Transient
	public RelLoginGroupDto create(UserDto user, String password, String groupName, Boolean active) {
		return create(user.getParent(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getValidEmail(),
				user.getCellphone(), user.getValidCellphone(), user.getDescription(), user.getPhoto(), active, password,
				groupName);
	}

	@Transient
	public RelLoginGroupDto update(UserDto parent, long userId, String firstname, String lastname, String email,
			Boolean validEmail, String cellphone, Boolean validCellphone, String description, String photo,
			Boolean isActive, String strPassword, String groupName) {

		GroupEntity group = groupRepo.find(groupName).orElseThrow(() -> new RuntimeException("Group name not found."));
		UserEntity user = userRepo.findByIdOptional(userId)
				.orElseThrow(() -> new RuntimeException("UserId not found."));
		user.setParent(userMapper.toEntity(parent));
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setValidEmail(validEmail);
		user.setCellphone(cellphone);
		user.setValidCellphone(validCellphone);
		user.setDescription(description);
		user.setPhoto(photo);

		LoginEntity login = loginRepo.find(userId).orElseThrow(() -> new RuntimeException("UserId not found."));
		if (!strPassword.isBlank())
			login.getPassword().setPassword(strPassword);
		login.setUser(user);
		login.setActive(isActive);

		RelLoginGroupEntity rlg = relLoginGroupRepo.find(login.getUser().getId())
				.orElseThrow(() -> new RuntimeException("UserId not found."));
		rlg.setGroup(group);
		relLoginGroupRepo.persist(rlg);
		return relLoginGroupMapper.toDTO(rlg);
	}

	@Transient
	@Override
	public RelLoginGroupDto update(UserDto user, String password, String groupName, Boolean active) {
		return update(user.getParent(), user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(),
				user.getValidEmail(), user.getCellphone(), user.getValidCellphone(), user.getDescription(),
				user.getPhoto(), active, password, groupName);
	}

	@Transient
	@Override
	public LoginDto updateUserActivation(long userid, Boolean active) {
		LoginEntity login = loginRepo.find(userid).orElseThrow(() -> new RuntimeException("UserId not found."));
		login.setActive(active);
		// Update object with panache with persist method.
		loginRepo.persist(login);
		return loginMapper.toDTO(login);
	}

	@Transient
	@Override
	public LoginDto delete(long userId) {
		userRepo.findByIdOptional(userId).orElseThrow(() -> new RuntimeException("UserId not found."));
		RelLoginGroupEntity relLoginGroup = relLoginGroupRepo.find(userId)
				.orElseThrow(() -> new RuntimeException("User not found."));
		relLoginGroupRepo.delete(relLoginGroup);
		return loginMapper.toDTO(relLoginGroup.getLogin());
	}

	@Override
	public List<FullInfoUserDto> getFullInfoUsersDto(int pageIndex, int pageSize, String sortBy, String order) {
		sortBy = sortBy == null ? "id" : sortBy;
		List<RelLoginGroupEntity> relLoginGroups = switch (order) {
		case "asc" -> relLoginGroupRepo.findAll(Sort.ascending(sortBy)).page(pageIndex - 1, pageSize).list();
		case "des" -> relLoginGroupRepo.findAll(Sort.descending(sortBy)).page(pageIndex - 1, pageSize).list();
		case null, default -> relLoginGroupRepo.findAll().page(pageIndex - 1, pageSize).list();
		};
		return relLoginGroups.stream().map(rlg -> new FullInfoUserDto(userMapper.toDTO(rlg.getLogin().getUser()), "",
				rlg.getGroup().getName(), rlg.getLogin().isActive())).toList();
	}

	@Override
	public List<FullInfoUserDto> getFullInfoUsersDto(long parentUserId, int pageIndex, int pageSize, String sortBy,
			String order) {
		sortBy = sortBy == null ? "id" : sortBy;
		List<RelLoginGroupEntity> relLoginGroups = switch (order) {
		case "asc" -> relLoginGroupRepo.findAll(Sort.ascending(sortBy)).page(pageIndex - 1, pageSize).list();
		case "des" -> relLoginGroupRepo.findAll(Sort.descending(sortBy)).page(pageIndex - 1, pageSize).list();
		case null, default -> relLoginGroupRepo.findAll().page(pageIndex - 1, pageSize).list();
		};
		return relLoginGroups.stream().map(rlg -> new FullInfoUserDto(userMapper.toDTO(rlg.getLogin().getUser()), "",
				rlg.getGroup().getName(), rlg.getLogin().isActive())).toList();
	}

	@Override
	public List<FullInfoUserDto> getFullTextSearch(String text, int pageIndex, int pageSize, String sortBy,
			String order) {
		sortBy = sortBy == null ? "id" : sortBy;
		List<RelLoginGroupEntity> relLoginGroups = switch (order) {
		case "asc" -> relLoginGroupRepo.findAll(Sort.ascending(sortBy)).page(pageIndex - 1, pageSize).list();
		case "des" -> relLoginGroupRepo.findAll(Sort.descending(sortBy)).page(pageIndex - 1, pageSize).list();
		case null, default -> relLoginGroupRepo.findAll().page(pageIndex - 1, pageSize).list();
		};
		return relLoginGroups.stream().map(rlg -> new FullInfoUserDto(userMapper.toDTO(rlg.getLogin().getUser()), "",
				rlg.getGroup().getName(), rlg.getLogin().isActive())).toList();
	}

	@Override
	public List<FullInfoUserDto> getFullTextSearch(String text, long userParentId, int pageIndex, int pageSize,
			String sortBy, String order) {
		sortBy = sortBy == null ? "id" : sortBy;
		List<RelLoginGroupEntity> relLoginGroups = switch (order) {
		case "asc" -> relLoginGroupRepo.findAll(Sort.ascending(sortBy)).page(pageIndex - 1, pageSize).list();
		case "des" -> relLoginGroupRepo.findAll(Sort.descending(sortBy)).page(pageIndex - 1, pageSize).list();
		case null, default -> relLoginGroupRepo.findAll().page(pageIndex - 1, pageSize).list();
		};
		return relLoginGroups.stream().map(rlg -> new FullInfoUserDto(userMapper.toDTO(rlg.getLogin().getUser()), "",
				rlg.getGroup().getName(), rlg.getLogin().isActive())).toList();
	}

	@Override
	public long getUserCount() {
		return userRepo.count();
	}

	@Override
	public long getGroupCount() {
		return groupRepo.count();
	}

	@Override
	@Transactional
	public GroupDto saveGroup(GroupDto groupDto) {
		GroupEntity entity = groupMapper.toEntity(groupDto);
		groupRepo.persist(entity);
		return groupMapper.toDTO(entity);
	}

}
