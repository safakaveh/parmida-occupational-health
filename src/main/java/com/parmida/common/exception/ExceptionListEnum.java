package com.parmida.common.exception;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ExceptionListEnum<T extends CustomRuntimeException> {
	public String getErrorCode();

	@JsonValue
	public int getHttpErrorCode();

	@JsonValue
	public String getMessage();

	public T getRuntimeException();

	public String toJson();
}
