package com.parmida.usermanagment.repository.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class LoginRepoException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "rpo_lgn";

	public enum LoginRepoExceptionList implements ExceptionListEnum<LoginRepoException> {
		NOT_FOUND(new ExceptionRecord("01", 404, "User not found.")),;

		private final ExceptionRecord exceptionRecord;

		private LoginRepoExceptionList(ExceptionRecord exceptionRecord) {
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

		public LoginRepoException getRuntimeException() {
			return new LoginRepoException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public LoginRepoException(LoginRepoExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}

}