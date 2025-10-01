package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;
import com.parmida.occupationalhealth.model.MeasureEntity;
import com.parmida.occupationalhealth.model.MedicalCheckUpsease;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MedicalCheckUpseaseDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	
	public record MedicalCheckUpseaseDtoRecord()  implements RecordDto {}
	
	
	private String code;
	
	private MedicalCheckUpsease parent;
	
	private String name;

	private MeasureDto measure ;
	
	private float maxMeasur;
	
	private float minMeasur;
	
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MedicalCheckUpsease getParent() {
		return parent;
	}

	public void setParent(MedicalCheckUpsease parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeasureDto getMeasure() {
		return measure;
	}

	public void setMeasure(MeasureDto measure) {
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
	@Override
	public <T extends RecordDto> T getRecord() {
		// TODO Auto-generated method stub
		return null;
	}



}
