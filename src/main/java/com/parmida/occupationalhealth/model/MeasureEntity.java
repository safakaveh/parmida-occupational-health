package com.parmida.occupationalhealth.model;

public class MeasureEntity {

	@Column(name = "MEASUR")
	private String measur;
	
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

	@Column(name = "DESCRIPTION")
	private String description;


}
