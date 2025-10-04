package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;
import com.parmida.occupationalhealth.model.JobEntity;

import jakarta.json.bind.JsonbBuilder;

public class RelVisitedJobDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	public record RelVisitedJobRecord(JobEntity job, String workingConditions, Boolean hasProblem, VisitedDto visited,
			Long datetime) implements RecordDto {
		public static final RelVisitedJobRecord fromString(String json) {
			return JsonbBuilder.create().fromJson(json, RelVisitedJobRecord.class);
		}
	}

	private JobEntity job;

	private String workingConditions;

	private Boolean hasProblem;

	private VisitedDto visited;

	private Long datetime;

	public JobEntity getJob() {
		return job;
	}

	public void setJob(JobEntity job) {
		this.job = job;
	}

	public String getWorkingConditions() {
		return workingConditions;
	}

	public void setWorkingConditions(String workingConditions) {
		this.workingConditions = workingConditions;
	}

	public Boolean getHasProblem() {
		return hasProblem;
	}

	public void setHasProblem(Boolean hasProblem) {
		this.hasProblem = hasProblem;
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

	@SuppressWarnings("unchecked")
	@Override
	public RelVisitedJobRecord getRecord() {
		// TODO Auto-generated method stub
		return new RelVisitedJobRecord(job, workingConditions, hasProblem, visited, datetime);
	}

}
