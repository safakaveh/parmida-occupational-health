package com.parmida.common.utils.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class UtilityException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "utility-";

	public enum UtilityExceptionList implements ExceptionListEnum<UtilityException> {
		PASSEORD_HASHING(new ExceptionRecord("01", 500, "Password hashing encountered an error.")),;

		private final ExceptionRecord exceptionRecord;

		private UtilityExceptionList(ExceptionRecord exceptionRecord) {
			this.exceptionRecord = new ExceptionRecord(exceptionRecord.errorCode(), exceptionRecord.httpErrorCode(),
					exceptionRecord.message());
		}

		@JsonValue
		public String getErrorCode() {
			return UNIQU_PREFIX_ERROR_CODE + exceptionRecord.errorCode();
		}

		@JsonValue
		public int getHttpErrorCode() {
			return exceptionRecord.httpErrorCode();
		}

		@JsonValue
		public String getMessage() {
			return exceptionRecord.message();
		}

		public UtilityException getRuntimeException() {
			return new UtilityException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public UtilityException(UtilityExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}

}