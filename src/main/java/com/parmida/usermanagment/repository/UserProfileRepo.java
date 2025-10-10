package com.parmida.usermanagment.repository;

import java.io.Serial;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.parmida.usermanagment.model.LoginEntity;
import com.parmida.usermanagment.model.PasswordEntity;
import com.parmida.usermanagment.model.UserEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public final class UserProfileRepo implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Inject
	private PasswordRepo passwordRepo;

	@Inject
	private UserRepo userRepo;

	@Inject
	private LoginRepo loginRepo;

	public boolean chengePassword(long loginID, String oldPassword, String newPassword)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		if (loginID == 0) {
			throw new RuntimeException("Please login first.");
		}
		LoginEntity le = loginRepo.findByIdOptional(loginID).orElseThrow(() -> new RuntimeException("User not found."));
		PasswordEntity ope = new PasswordEntity(oldPassword);
		PasswordEntity pe = le.getPassword();
		if (!pe.getEncryptedPassword().equals(ope.getEncryptedPassword())) {
			throw new RuntimeException("Password is wrong.");
		}
		pe.setPassword(newPassword);
		passwordRepo.persist(pe);
		return true;
	}

	public UserEntity getUserProfile(long loginID) throws Exception {
		if (loginID == 0) {
			throw new RuntimeException("User not valid.");
		}
		return userRepo.find(loginID).orElseThrow(() -> new RuntimeException("User not found."));
	}

	public UserEntity updateUserProfile(long loginID, UserEntity userEntity) throws Exception {
		if (loginID == 0) {
			throw new RuntimeException("User not valid.");
		}
		UserEntity ue = userRepo.find(loginID).orElseThrow(() -> new RuntimeException("User not found."));
		userEntity.setId(ue.getId());
		userRepo.persist(userEntity);
		return userEntity;
	}

}
