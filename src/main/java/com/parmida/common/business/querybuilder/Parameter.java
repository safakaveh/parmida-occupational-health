package com.parmida.common.business.querybuilder;

public class Parameter {
	private String field;
	private String param;
	private Object data;
	private ComparativeOperatorEnum comparativeOperator;

	public Parameter() {
		super();
	}

	public Parameter(String field, String param, Object data, ComparativeOperatorEnum comparativeOperator) {
		super();
		this.field = field;
		this.param = param;
		this.data = data;
		this.comparativeOperator = comparativeOperator;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ComparativeOperatorEnum getComparativeOperator() {
		return comparativeOperator;
	}

	public void setComparativeOperator(ComparativeOperatorEnum comparativeOperator) {
		this.comparativeOperator = comparativeOperator;
	}

}
