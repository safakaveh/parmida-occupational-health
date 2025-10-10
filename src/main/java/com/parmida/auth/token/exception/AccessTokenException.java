package com.parmida.auth.token.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class AccessTokenException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "jwt-isu-";

	public enum AccessTokenExceptionList implements ExceptionListEnum<AccessTokenException> {
		AUTH_IS_EMPTY(new ExceptionRecord("01", 403, "Authentication is empty.")),
		USERNAME_AND_PASSWORD_NOT_FOUND(new ExceptionRecord("01", 403, "Username or password is wrong.")),
		ID_NOT_FOUND(new ExceptionRecord("01", 403, "User id not found.")),
		JWT_GENERATION_HAS_ERROR(new ExceptionRecord("02", 403, "There is an error generating the JWT.")),;

		private final ExceptionRecord exceptionRecord;

		private AccessTokenExceptionList(ExceptionRecord exceptionRecord) {
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

		public AccessTokenException getRuntimeException() {
			return new AccessTokenException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public AccessTokenException(AccessTokenExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}
}