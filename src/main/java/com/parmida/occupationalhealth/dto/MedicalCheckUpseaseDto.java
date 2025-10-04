package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import jakarta.json.bind.JsonbBuilder;

public class MedicalCheckUpseaseDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	public record MedicalCheckUpseaseDtoRecord(String code, MedicalCheckUpseaseDto parent, String name,
			MeasureDto measure, float maxMeasur, float minMeasur) implements RecordDto {
		public static final MedicalCheckUpseaseDtoRecord fromString(String json) {
			return JsonbBuilder.create().fromJson(json, MedicalCheckUpseaseDtoRecord.class);
		}
	}

	private String code;

	private MedicalCheckUpseaseDto parent;

	private String name;

	private MeasureDto measure;

	private float maxMeasur;

	private float minMeasur;

	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MedicalCheckUpseaseDto getParent() {
		return parent;
	}

	public void setParent(MedicalCheckUpseaseDto parent) {
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

	@SuppressWarnings("unchecked")
	@Override
	public MedicalCheckUpseaseDtoRecord getRecord() {
		return new MedicalCheckUpseaseDtoRecord(code, parent, name, measure, maxMeasur, minMeasur);
	}

}
