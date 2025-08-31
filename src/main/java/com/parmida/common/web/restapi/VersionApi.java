package com.parmida.common.web.restapi;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VersionApi {
	@Inject
	@ConfigProperty(name = "application.version")
	String version;

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getVersion() {
		return Response.ok().entity(version).build();
	}
}
