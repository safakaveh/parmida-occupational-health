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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "MEDICAL_CHECKUPSEASES", indexes = { @Index(columnList = "CODE"), @Index(columnList = "ID_PARENT"),
		@Index(columnList = "ID_MEASURE") }, uniqueConstraints = { @UniqueConstraint(columnNames = "CODE") })
public class MedicalCheckupseaseEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "CODE")
	private String code;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_PARENT")
	private MedicalCheckupseaseEntity parent;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_MEASURE")
	private MeasureEntity measure;

	@Column(name = "MAXMEASUR")
	private float maxMeasur;

	@Column(name = "MINMEASUR")
	private float minMeasur;

	@Column(name = "DESCRIPTION")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MedicalCheckupseaseEntity getParent() {
		return parent;
	}

	public void setParent(MedicalCheckupseaseEntity parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeasureEntity getMeasure() {
		return measure;
	}

	public void setMeasure(MeasureEntity measure) {
		this.measure = measure;
	}

	public float getMaxMeasur() {
		return maxMeasur;
	}

	public void setMaxMeasur(float maxMeasur) {
		this.maxMeasur = maxMeasur;
	}

	public float getMinMeasur() {
		return minMeasur;
	}

	public void setMinMeasur(float minMeasur) {
		this.minMeasur = minMeasur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
