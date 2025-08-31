package com.parmida.common.exception;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public record ExceptionRecord(String errorCode, int httpErrorCode, String message) {
	@Override
	public final String toString() {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.toJson(this);
	}
}
