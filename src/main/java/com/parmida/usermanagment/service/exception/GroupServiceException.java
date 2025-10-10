package com.parmida.usermanagment.service.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class GroupServiceException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "srv_grp";

	public enum GroupServiceExceptionList implements ExceptionListEnum<GroupServiceException> {
		NOT_FOUND(new ExceptionRecord("01", 404, "Group not found.")),;

		private final ExceptionRecord exceptionRecord;

		private GroupServiceExceptionList(ExceptionRecord exceptionRecord) {
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

		public GroupServiceException getRuntimeException() {
			return new GroupServiceException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public GroupServiceException(GroupServiceExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}

}