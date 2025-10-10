package com.parmida.usermanagment.repository.exception;

import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonValue;
import com.parmida.common.exception.CustomRuntimeException;
import com.parmida.common.exception.ExceptionListEnum;
import com.parmida.common.exception.ExceptionRecord;

public class GroupRepoException extends CustomRuntimeException {
	private static final String UNIQU_PREFIX_ERROR_CODE = "rpo_grp";

	public enum GroupRepoExceptionList implements ExceptionListEnum<GroupRepoException> {
		NOT_FOUND(new ExceptionRecord("01", 404, "Group not found.")),;

		private final ExceptionRecord exceptionRecord;

		private GroupRepoExceptionList(ExceptionRecord exceptionRecord) {
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

		public GroupRepoException getRuntimeException() {
			return new GroupRepoException(this);
		}

		public String toJson() {
			return exceptionRecord.toString();
		}
	}

	@Serial
	private static final long serialVersionUID = 1L;

	public GroupRepoException(GroupRepoExceptionList exceptionList) {
		super(exceptionList, UNIQU_PREFIX_ERROR_CODE);
	}
}