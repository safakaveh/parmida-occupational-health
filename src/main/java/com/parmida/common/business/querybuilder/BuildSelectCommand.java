package com.parmida.common.business.querybuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuildSelectCommand<T> {
	private String query = "select e from %s as e";
	private List<Parameter> parameters;

	public BuildSelectCommand(Class<T> clazz) {
		query = String.format(query, clazz.getSimpleName());
		parameters = new ArrayList<>();
	}

	public BuildSelectCommand(Class<T> clazz, List<Parameter> parameters) {
		query = String.format(query, clazz.getSimpleName());
		this.parameters = parameters.stream().filter(p -> p.getData() != null).collect(Collectors.toList());
	}

	public BuildSelectCommand(Class<T> clazz, Parameter... parameters) {
		this(clazz, Arrays.asList(parameters));
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public void setParameters(Parameter... parameters) {
		this.parameters = Arrays.asList(parameters);
	}

	public Map<String, Object> getParameters() {
		if (parameters == null || parameters.isEmpty()) {
			return new HashMap<>();
		}
		return parameters.stream().collect(Collectors.toMap(Parameter::getParam, Parameter::getData));
	}

	public String getQuery() {
		if (parameters == null || parameters.isEmpty()) {
			return query;
		}
		query += " where " + parameters.stream()
				.map(p -> "e." + p.getField() + " " + p.getComparativeOperator().getSign() + " :" + p.getParam())
				.collect(Collectors.joining(" and "));
		return query;
	}

}
