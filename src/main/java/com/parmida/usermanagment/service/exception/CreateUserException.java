package com.parmida.usermanagment.service.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class CreateUserException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "jwt-isu-";

	public enum CreateUserExceptionList implements ExceptionListEnum<CreateUserException> {
		JWT_NOT_FOUNG(new ExceptionRecord("02", 403, "Please login ...")),
		LOGIN_ID_NOT_FOUND(new ExceptionRecord("01", 404, "Login not found")),;

		private final ExceptionRecord exceptionRecord;

		private CreateUserExceptionList(ExceptionRecord exceptionRecord) {
			this.exceptionRecord = new ExceptionRecord(UNIQU_PREFIX_ERROR_CODE + exceptionRecord.errorCode(),
					exceptionRecord.httpErrorCode(), exceptionRecord.message());
		}

		@JsonValue
		public String getErrorCode() {
			return exceptionRecord.errorCode();
		}

		@JsonValue
		public int getHttpErrorCode() {
			return exceptionRecord.httpErrorCode();
		}

		@JsonValue
		public String getMessage() {
			return exceptionRecord.message();
		}

		public CreateUserException getRuntimeException() {
			return new CreateUserException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public CreateUserException(ExceptionListEnum<?> exceptionListEnum) {
		super(exceptionListEnum, UNIQU_PREFIX_ERROR_CODE);
	}

}
