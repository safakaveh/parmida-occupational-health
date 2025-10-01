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
@Table(name = "REL_VISITED_JOBS", indexes = { @Index(columnList = "ID_JOB"), @Index(columnList = "ID_VISITED") })
public class RelVisitedJobEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_JOB")
	private JobEntity job;

	@Column(name = "WORKINGCONDITIONS")
	private String workingConditions;

	@Column(name = "HASPROBLEM")
	private Boolean hasProblem;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_VISITED")
	private VisitedEntity visited;

	@Column(name = "DATETIME")
	private Long datetime;

	public JobEntity getJob() {
		return job;
	}

	public void setJob(JobEntity job) {
		this.job = job;
	}

	public String getWorkingConditions() {
		return workingConditions;
	}

	public void setWorkingConditions(String workingConditions) {
		this.workingConditions = workingConditions;
	}

	public Boolean getHasProblem() {
		return hasProblem;
	}

	public void setHasProblem(Boolean hasProblem) {
		this.hasProblem = hasProblem;
	}

	public VisitedEntity getVisited() {
		return visited;
	}

	public void setVisited(VisitedEntity visited) {
		this.visited = visited;
	}

	public Long getDatetime() {
		return datetime;
	}

	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}

}
