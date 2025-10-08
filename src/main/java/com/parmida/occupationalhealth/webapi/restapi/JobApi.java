package com.parmida.occupationalhealth.webapi.restapi;

import com.parmida.occupationalhealth.dto.JobDto;
import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.service.JobService;
import com.parmida.occupationalhealth.service.OrganizationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/job")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class JobApi {
	@Inject
	private JobService jobService;

	public Response save(JobDto  job) {
		JobDto dto = jobService.save(job );
		return Response.status(Status.CREATED).entity(dto).build();
	}

}
