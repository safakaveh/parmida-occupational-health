package com.parmida.occupationalhealth.webapi.restapi;

import com.parmida.occupationalhealth.dto.RelVisitedMedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.dto.VisitedDto;
import com.parmida.occupationalhealth.service.RelVisitedMedicalCheckUpseaseService;
import com.parmida.occupationalhealth.service.VisitedService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/visited")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class VisitedApi {
	@Inject
	private VisitedService  visitedService;

	public Response save(VisitedDto  visited) {
		VisitedDto dto = visitedService.save(visited);
		return Response.status(Status.CREATED).entity(dto).build();
	}



}
