package com.parmida.common.web.exception;

import org.jboss.logging.Logger;

import com.parmida.common.converter.JsonConverter;
import com.parmida.common.exception.CustomRuntimeException;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<CustomRuntimeException> {
	private Logger log;

	@Inject
	public BusinessExceptionMapper(Logger log) {
		this.log = log;
	}

	@Override
	public Response toResponse(CustomRuntimeException exception) {
		log.error(JsonConverter.toJsonString(exception.getExceptionInformation()));
		return Response.status(exception.getExceptionInformation().getHttpErrorCode())
				.entity(exception.getExceptionInformation().getMessage()).type(MediaType.APPLICATION_JSON).build();
	}

}
