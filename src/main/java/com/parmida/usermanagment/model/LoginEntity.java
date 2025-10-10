package com.parmida.usermanagment.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOGINS", indexes = { @Index(columnList = "ID_USER"),
		@Index(columnList = "id_password") }, uniqueConstraints = {})

@NamedQuery(name = "Login.find(username)", query = "select l from LoginEntity as l where (l.user.email = :username or l.user.cellphone = :username)")
@NamedQuery(name = "Login.find(userId)", query = "select l from LoginEntity as l where l.user.id = :userId")
@NamedQuery(name = "Login.find(username,password)", query = "select l from LoginEntity as l where (l.user.email = :username or l.user.cellphone = :username) and (l.password.encryptedPassword = :password)")

@NamedNativeQueries({})
public class LoginEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = { CascadeType.REMOVE, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER")
	private UserEntity user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PASSWORD")
	private PasswordEntity password;

	@Column(name = "IS_ACTIVE")
	private Boolean active;

	public LoginEntity() {
		super();
	}

	public LoginEntity(UserEntity user, PasswordEntity password, Boolean active) {
		super();
		this.user = user;
		this.password = password;
		this.active = active;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PasswordEntity getPassword() {
		return password;
	}

	public void setPassword(PasswordEntity password) {
		this.password = password;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
