package com.parmida.usermanagment.web.restapi;

import java.io.Serial;
import java.io.Serializable;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.parmida.usermanagment.dto.FullInfoUserDto;
import com.parmida.usermanagment.service.CreateUserService;
import com.parmida.usermanagment.service.ManipulateUserService;
import com.parmida.usermanagment.service.exception.CreateUserException;
import com.parmida.usermanagment.service.exception.CreateUserException.CreateUserExceptionList;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Create User Api", description = "")
@RequestScoped
public class UserApi implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Inject
	@Claim(standard = Claims.sub)
	String sub;

	@Inject
	@Named("CreateUserService")
	private CreateUserService createUserService;

	@Inject
	@Named("ManipulateUserService")
	private ManipulateUserService manipulateUserService;

	@PermitAll
	@Path("/create")
	@POST
	@Operation(summary = "Save new user remote")
	public Response saveUser(FullInfoUserDto userDto) {
		if (sub == null || sub.isEmpty()) {
			throw new CreateUserException(CreateUserExceptionList.JWT_NOT_FOUNG);
		}

		long loginId = Long.parseLong(sub.split("-")[0]);
		FullInfoUserDto result = createUserService.create(userDto, loginId);
		return Response.status(Status.CREATED).entity(result).build();
	}

}
