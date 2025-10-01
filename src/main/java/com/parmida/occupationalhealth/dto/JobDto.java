package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;
import com.parmida.occupationalhealth.dto.VisitedDto.VisitedRecord;

import jakarta.json.bind.JsonbBuilder;

public class JobDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	public static record JobRecord(OrganizhationDto organization, String measur, JobDto parent, String description)
			implements RecordDto {
		public static final VisitedRecord fromString(String json) {
			return JsonbBuilder.create().fromJson(json, VisitedRecord.class);
		}
	}

	private OrganizhationDto organization;

	private String measur;

	private JobDto parent;

	private String description;

	public OrganizhationDto getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizhationDto organization) {
		this.organization = organization;
	}

	public String getMeasur() {
		return measur;
	}

	public void setMeasur(String measur) {
		this.measur = measur;
	}

	public JobDto getParent() {
		return parent;
	}

	public void setParent(JobDto parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JobRecord getRecord() {
		return new JobRecord(organization, measur, parent, description);
	}

}
