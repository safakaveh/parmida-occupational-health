package com.parmida.common.exception;

import java.io.Serial;

public abstract class CustomRuntimeException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;
	private ExceptionListEnum<?> exceptionListEnum;

	public CustomRuntimeException(ExceptionListEnum<?> exceptionListEnum, String uniquPrefixErrorCode) {
		super(exceptionListEnum.getMessage());
		this.exceptionListEnum = exceptionListEnum;
	}

	public ExceptionListEnum<?> getExceptionInformation() {
		return this.exceptionListEnum;
	};
}
