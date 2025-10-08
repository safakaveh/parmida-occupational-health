package com.parmida.occupationalhealth.webapi.restapi;

import com.parmida.occupationalhealth.dto.MedicalCheckUpseaseDto;
import com.parmida.occupationalhealth.dto.RelVisitedJobDto;
import com.parmida.occupationalhealth.service.MedicalCheckupseaseService;
import com.parmida.occupationalhealth.service.RelVisitedJobService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/relVisitedJob")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class RelVisitedJobApi {
		@Inject
		private RelVisitedJobService  relVisitedJobService;

		public Response save(RelVisitedJobDto  relVisitedJob) {
			RelVisitedJobDto dto = relVisitedJobService.save(relVisitedJob);
			return Response.status(Status.CREATED).entity(dto).build();
		}



}
