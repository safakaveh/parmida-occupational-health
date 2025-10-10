package com.parmida.usermanagment.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "REL_LOGIN_GROUP", indexes = { @Index(columnList = "ID_LOGIN"),
		@Index(columnList = "ID_GROUP") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = { "ID_LOGIN", "ID_GROUP" }) })

@NamedQuery(name = "RelLoginGroup.find(userId)", query = "select rlg from RelLoginGroupEntity as rlg where rlg.login.user.id = :userId")
@NamedQuery(name = "RelLoginGroup.find(parentUserId):List", query = "select rlg from RelLoginGroupEntity as rlg where rlg.login.user.parent.id = :parentUserId")
@NamedQuery(name = "RelLoginGroup.User.getCountUsers.groupName_userParentId", query = "select count(rlg) from RelLoginGroupEntity as rlg where rlg.group.name = :groupName and rlg.login.user.parent.id = :userParentId")
@NamedQuery(name = "RelLoginGroup.count(groupName)", query = "select count(rlg) from RelLoginGroupEntity as rlg where rlg.group.name = :groupName")
@NamedQuery(name = "RelLoginGroup.fullTextSearch(text):List", query = "select rlg from RelLoginGroupEntity as rlg  where concat(rlg.group.name,rlg.login.user.firstname,rlg.login.user.lastname,rlg.login.user.email,rlg.login.user.cellphone,rlg.login.user.description) like :text")
@NamedQuery(name = "RelLoginGroup.fullTextSearch(text,userParentId):List", query = "select rlg from RelLoginGroupEntity as rlg  where concat(rlg.group.name,rlg.login.user.firstname,rlg.login.user.lastname,rlg.login.user.email,rlg.login.user.cellphone,rlg.login.user.description) like :text and rlg.login.user.parent.id = :userParentId ")
@NamedQuery(name = "RelLoginGroup.fullTextSearch(text,groupName):List", query = "select rlg from RelLoginGroupEntity as rlg  where ((concat(rlg.login.user.firstname, rlg.login.user.lastname)) like :text) and rlg.group.name = :groupName")
@NamedQuery(name = "RelLoginGroup.fullTextSearch(text,groupName,active):List", query = "select rlg from RelLoginGroupEntity as rlg join rlg.login.user as u  where  (u.firstname like :text) and rlg.group.name = :groupName and rlg.login.active = :active")
//((concat(rlg.login.user.firstname, rlg.login.user.lastname)) like :text) and 
public class RelLoginGroupEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_LOGIN")
	private LoginEntity login;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_GROUP")
	private GroupEntity group;

	public RelLoginGroupEntity() {
		super();
	}

	public RelLoginGroupEntity(LoginEntity login, GroupEntity group) {
		super();
		this.login = login;
		this.group = group;
	}

	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

}
