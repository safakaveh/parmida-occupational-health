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
@Table(name = "REL_VISITED_MEDICAL_CHECKUPSEASE", indexes = { @Index(columnList = "ID_MDICALCHECKUPSEASE"),
		@Index(columnList = "ID_VISITED") })

public class RelVisitedMedicalCheckUpseaseEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_MDICALCHECKUPSEASE")
	private MedicalCheckupseaseEntity mdicalCheckUpsease;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_VISITED")
	private VisitedEntity visited;

	@Column(name = "DATETIME")
	private Long datetime;

	@Column(name = "VALUE")
	private Float value;

	public MedicalCheckupseaseEntity getMdicalCheckUpsease() {
		return mdicalCheckUpsease;
	}

	public void setMdicalCheckUpsease(MedicalCheckupseaseEntity mdicalCheckUpsease) {
		this.mdicalCheckUpsease = mdicalCheckUpsease;
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

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

}
