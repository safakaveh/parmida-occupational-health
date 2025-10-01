package com.parmida.occupationalhealth.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOBS", indexes = { @Index(columnList = "ID_ORGANIZATION"), @Index(columnList = "ID_PARENT") })
public class JobEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_ORGANIZATION")
	private OrganizationEntity organization;

	@Column(name = "TITLE")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_PARENT")
	private JobEntity parent;

	@Column(name = "DESCRIPTION")
	private String description;

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JobEntity getParent() {
		return parent;
	}

	public void setParent(JobEntity parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
