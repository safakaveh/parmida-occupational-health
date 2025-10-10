package com.parmida.usermanagment.repository.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class PasswordRepoException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "rpo_pwd";

	public enum PasswordRepoExceptionList implements ExceptionListEnum<PasswordRepoException> {
		NOT_FOUND(new ExceptionRecord("01", 404, "Password not found.")),;

		private final ExceptionRecord exceptionRecord;

		private PasswordRepoExceptionList(ExceptionRecord exceptionRecord) {
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

		public PasswordRepoException getRuntimeException() {
			return new PasswordRepoException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public PasswordRepoException(PasswordRepoExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}

}