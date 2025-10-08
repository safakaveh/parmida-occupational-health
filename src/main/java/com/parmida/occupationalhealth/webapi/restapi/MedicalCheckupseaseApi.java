package com.parmida.occupationalhealth.webapi.restapi;

import com.parmida.occupationalhealth.dto.MedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.dto.OrganizationDto;
import com.parmida.occupationalhealth.service.MedicalCheckupseaseService;
import com.parmida.occupationalhealth.service.OrganizationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/medicalCheckupsease")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MedicalCheckupseaseApi {
	@Inject
	private MedicalCheckupseaseService medicalCheckupseaseService;

	public Response save(MedicalCheckUpseaseDto  medicalCheckUpsease) {
		MedicalCheckUpseaseDto dto = medicalCheckupseaseService.save(medicalCheckUpsease);
		return Response.status(Status.CREATED).entity(dto).build();
	}

}
