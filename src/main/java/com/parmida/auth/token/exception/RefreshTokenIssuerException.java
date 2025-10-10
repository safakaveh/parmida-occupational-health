package com.parmida.auth.token.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class RefreshTokenIssuerException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "jwt-isu-";

	public enum RefreshTokenIssuerExceptionList implements ExceptionListEnum<RefreshTokenIssuerException> {
		REFRESH_TOKEN_NOT_FOUND(new ExceptionRecord("01", 403, "Refresh token not found.")),
		INVALID_UUID(new ExceptionRecord("02", 403, "UUID is invalid.")), REFRESH_TOKEN_GENERATION_HAS_ERROR(
				new ExceptionRecord("03", 403, "There is an error generating the refresh token.")),;

		private final ExceptionRecord exceptionRecord;

		private RefreshTokenIssuerExceptionList(ExceptionRecord exceptionRecord) {
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

		public RefreshTokenIssuerException getRuntimeException() {
			return new RefreshTokenIssuerException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public RefreshTokenIssuerException(RefreshTokenIssuerExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}

}