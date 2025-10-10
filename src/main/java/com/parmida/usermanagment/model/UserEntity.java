package com.parmida.usermanagment.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USERS", indexes = { @Index(columnList = "ID_PARENT"), @Index(columnList = "EMAIL"),
		@Index(columnList = "CELLPHONE") }, uniqueConstraints = { @UniqueConstraint(columnNames = "EMAIL"),
				@UniqueConstraint(columnNames = "cellphone") })

@Inheritance

@NamedQuery(name = "User.find(parentId):List", query = "select e from UserEntity as e where e.parent.id = :parentId")
@NamedQuery(name = "User.find(groupName,userParentId):List", query = "select rlg.login.user from RelLoginGroupEntity as rlg where rlg.group.name = :groupName and rlg.login.user.parent.id = :userParentId")
@NamedQuery(name = "User.find(groupName):List", query = "select rlg.login.user from RelLoginGroupEntity as rlg where rlg.group.name = :groupName")
@NamedQuery(name = "User.fullTextSearch(text,groupName):List", query = "select rlg.login.user from RelLoginGroupEntity as rlg  where concat(rlg.group.name,rlg.login.user.firstname,rlg.login.user.lastname,rlg.login.user.email,rlg.login.user.cellphone,rlg.login.user.description) like :text and rlg.group.name = :groupName ")
@NamedQuery(name = "User.find(loginId)", query = "select l.user from LoginEntity as l where (l.id = :loginId)")
public class UserEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PARENT")
	private UserEntity parent;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IS_VALID_EMAIL")
	private Boolean validEmail;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "IS_VALID_CELLPHONE")
	private Boolean validCellphone;

	@Column(name = "DESCRIPTION")
	private String description;

	@Lob
	@Column(name = "PHOTO")
	private String photo;

	public UserEntity() {
		super();
	}

	public UserEntity(UserEntity parent, String firstname, String lastname, String email, Boolean validEmail,
			String cellphone, Boolean validCellphone, String description, String photo) {
		super();
		this.parent = parent;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.validEmail = validEmail;
		this.cellphone = cellphone;
		this.validCellphone = validCellphone;
		this.description = description;
		this.photo = photo;
	}

	public UserEntity getParent() {
		return parent;
	}

	public void setParent(UserEntity parent) {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Boolean isValidEmail() {
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

	public Boolean isValidCellphone() {
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

}
