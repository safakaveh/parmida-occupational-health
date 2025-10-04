package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;
import com.parmida.occupationalhealth.model.MedicalCheckupseaseEntity;

import jakarta.json.bind.JsonbBuilder;

public class RelVisitedMedicalCheckUpseaseDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	public record RelVisitedMedicalCheckUpseaseRecord(MedicalCheckupseaseEntity mdicalCheckUpsease, VisitedDto visited,
			Long datetime, Float value) implements RecordDto {
		public static final RelVisitedMedicalCheckUpseaseRecord fromString(String json) {
			return JsonbBuilder.create().fromJson(json, RelVisitedMedicalCheckUpseaseRecord.class);
		}
	}

	private MedicalCheckupseaseEntity mdicalCheckUpsease;

	private VisitedDto visited;

	private Long datetime;

	private Float value;

	public MedicalCheckupseaseEntity getMdicalCheckUpsease() {
		return mdicalCheckUpsease;
	}

	public void setMdicalCheckUpsease(MedicalCheckupseaseEntity mdicalCheckUpsease) {
		this.mdicalCheckUpsease = mdicalCheckUpsease;
	}

	public VisitedDto getVisited() {
		return visited;
	}

	public void setVisited(VisitedDto visited) {
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

	@SuppressWarnings("unchecked")
	@Override
	public RelVisitedMedicalCheckUpseaseRecord getRecord() {
		return new RelVisitedMedicalCheckUpseaseRecord(mdicalCheckUpsease, visited, datetime, value);
	}

}
