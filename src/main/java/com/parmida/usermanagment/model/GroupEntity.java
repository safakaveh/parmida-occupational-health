package com.parmida.usermanagment.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "GROUPS", uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })

@NamedQuery(name = "Group.find(groupName)", query = "select g from GroupEntity g where g.name = :groupName")
@NamedQuery(name = "Group.find(loginId):List", query = "select rlg.group from RelLoginGroupEntity as rlg where rlg.login.id = :loginId")

@NamedNativeQueries({})
public class GroupEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	public GroupEntity() {
		super();
	}

	public GroupEntity(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
