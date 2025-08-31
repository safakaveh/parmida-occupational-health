package com.parmida.common.web.restapi;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ping")
public class PingApi {
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPing() {
		return Response.ok().entity("pong").build();
	}

	@GET
	@Path("/admin")
	@RolesAllowed({ "admin" })
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAdminPing() {
		return Response.ok().entity("PONG_ADMIN").build();
	}

	@GET
	@Path("/supporter")
	@RolesAllowed({ "supporter" })
	@Produces(MediaType.TEXT_PLAIN)
	public Response getSupporterPing() {
		return Response.ok().entity("PONG_SUPPORTER").build();
	}

	@GET
	@Path("/device")
	@RolesAllowed({ "device" })
	@Produces(MediaType.TEXT_PLAIN)
	public Response getDevicePing() {
		return Response.ok().entity("PONG_DEVICE").build();
	}

	@GET
	@Path("/customer")
	@RolesAllowed({ "customer" })
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCustomer() {
		return Response.ok().entity("PONG_CUSTOMER").build();
	}
}
