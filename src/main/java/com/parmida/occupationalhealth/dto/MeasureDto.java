package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import jakarta.json.bind.JsonbBuilder;

public class MeasureDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	
	public record MeasuRercord(String measur, String measurid, String description) implements RecordDto {
		public static final MeasuRercord fromString(String json) {
			return JsonbBuilder.create().fromJson(json, MeasuRercord.class);
		}
	}

	private String measur;

	private String measurid;

	private String description;

	public String getMeasur() {
		return measur;
	}

	public void setMeasur(String measur) {
		this.measur = measur;
	}

	public String getMeasurid() {
		return measurid;
	}

	public void setMeasurid(String measurid) {
		this.measurid = measurid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MeasuRercord getRecord() {
		return new MeasuRercord(measur, measurid, description);
	}

}
