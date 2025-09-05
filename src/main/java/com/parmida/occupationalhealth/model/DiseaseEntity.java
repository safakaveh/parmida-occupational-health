package com.parmida.occupationalhealth.model;

public class DiseaseEntity {

	@Column(name = "CODE")
	private String code;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_MEASURE")
	private MeasureEntity measure;
	
	@Column(name = "DESCRIPTION")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
