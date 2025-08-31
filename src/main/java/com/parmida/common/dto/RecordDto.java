package com.parmida.common.dto;

import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.annotation.JsonbTransient;

public abstract interface RecordDto {
	@JsonbTransient
	public default String json() {
		return JsonbBuilder.create().toJson(this);
	}

}
