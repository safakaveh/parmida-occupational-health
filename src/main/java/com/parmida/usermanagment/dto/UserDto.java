package com.parmida.usermanagment.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.JsonbBuilder;

@RegisterForReflection
public class UserDto extends MainDto {
	public static record User(Long id, Long version, Long createOn, Long updateOn, Boolean deleted, UserDto parent,
			String firstname, String lastname, String email, Boolean validEmail, String cellphone,
			Boolean validCellphone, String description, String photo) implements RecordDto {
		public static final User fromString(String json) {
			return JsonbBuilder.create().fromJson(json, User.class);
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	private UserDto parent;

	private String firstname;

	private String lastname;

	private String email;

	private Boolean validEmail;

	private String cellphone;

	private Boolean validCellphone;

	private String description;

	private String photo;

	public UserDto() {
		super();
	}

	public UserDto getParent() {
		return parent;
	}

	public void setParent(UserDto parent) {
		this.parent = parent;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(Boolean validEmail) {
		this.validEmail = validEmail;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Boolean getValidCellphone() {
		return validCellphone;
	}

	public void setValidCellphone(Boolean validCellphone) {
		this.validCellphone = validCellphone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getRecord() {
		return new User(id, version, createOn, updateOn, deleted, parent, firstname, lastname, email, validEmail,
				cellphone, validCellphone, description, photo);
	}

}
