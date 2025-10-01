package com.parmida.occupationalhealth.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "MEASURS", uniqueConstraints = { @UniqueConstraint(columnNames = "MEASUR") })
public class MeasureEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "MEASUR")
	private String measur;

	@Column(name = "DESCRIPTION")
	private String description;

	public String getMeasur() {
		return measur;
	}

	public void setMeasur(String measur) {
		this.measur = measur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
