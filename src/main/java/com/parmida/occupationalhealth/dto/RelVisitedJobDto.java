package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;
import com.parmida.occupationalhealth.model.JobEntity;
import com.parmida.occupationalhealth.model.VisitedEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RelVisitedJobDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	public record RelVisitedRecord () implements RecordDto {}
	
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
	@Override
	public <T extends RecordDto> T getRecord() {
		// TODO Auto-generated method stub
		return null;
	}


}
