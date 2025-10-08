package com.parmida.occupationalhealth.webapi.restapi;

import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.dto.RelVisitedMedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.service.OrganizationService;
import com.parmida.occupationalhealth.service.RelVisitedMedicalCheckUpseaseService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/relVisitedMedicalCheckUpsease")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class RelVisitedMedicalCheckUpseaseApi {
	@Inject
	private RelVisitedMedicalCheckUpseaseService  relVisitedMedicalCheckUpseaseService;

	public Response save(RelVisitedMedicalCheckUpseaseDto  relVisitedMedicalCheckUpsease) {
		RelVisitedMedicalCheckUpseaseDto dto = relVisitedMedicalCheckUpseaseService.save(relVisitedMedicalCheckUpsease);
		return Response.status(Status.CREATED).entity(dto).build();
	}



}
