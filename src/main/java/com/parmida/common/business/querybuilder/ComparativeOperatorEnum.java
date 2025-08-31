package com.parmida.common.business.querybuilder;

public enum ComparativeOperatorEnum {
	GREATER_THAN(">"), GREATER_THAN_OR_EQUAL_TO(">="), LESS_THAN("<"), LESS_THAN_OR_EQUAL_TO("<="), NOT_EQUAL("<>"),
	EQUAL("=");

	private String sign;

	private ComparativeOperatorEnum(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}
}
