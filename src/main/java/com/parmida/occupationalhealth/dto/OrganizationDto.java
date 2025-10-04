package com.parmida.occupationalhealth.dto;

import java.io.Serial;

import com.parmida.common.dto.MainDto;
import com.parmida.common.dto.RecordDto;

import jakarta.json.bind.JsonbBuilder;

public class OrganizationDto extends MainDto {
	@Serial
	private static final long serialVersionUID = 1L;

	public record OrganizationRecord(String name, String phone, String address, Integer employeeCount)
			implements RecordDto {
		public static final OrganizationRecord fromString(String json) {
			return JsonbBuilder.create().fromJson(json, OrganizationRecord.class);
		}

	}

	private String name;

	private String phone;

	private String address;

	private Integer employeeCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(Integer employeeCount) {
		this.employeeCount = employeeCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationRecord getRecord() {
		return new OrganizationRecord(name, phone, address, employeeCount);
	}

}
