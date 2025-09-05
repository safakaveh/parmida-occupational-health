package model.dto;

import java.io.Serial;

import com.parmida.occupationalhealth.common.enumeration.Gender;
import com.parmida.occupationalhealth.common.enumeration.MarridationStatus;
import com.parmida.occupationalhealth.model.Column;
import com.parmida.occupationalhealth.model.Enumerated;
import com.parmida.occupationalhealth.model.JoinColumn;
import com.parmida.occupationalhealth.model.ManyToOne;
import com.parmida.occupationalhealth.model.Organization;

public class VistedDto {

	
	
	private String firstname;

	
	private String lastname;

	
	private String nationalId;

	
	private Gender gender;

	
	private Long birthday;

	
	private String job;

	
	private String education;

	
	private String phone;

	
	private String address;

	
	private Integer childCount;

	
	private String ethnicity;

	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getNationalId() {
		return nationalId;
	}


	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Long getBirthday() {
		return birthday;
	}


	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
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


	public Integer getChildCount() {
		return childCount;
	}


	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}


	public String getEthnicity() {
		return ethnicity;
	}


	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}


	public Float getHeight() {
		return height;
	}


	public void setHeight(Float height) {
		this.height = height;
	}


	public Float getWeight() {
		return weight;
	}


	public void setWeight(Float weight) {
		this.weight = weight;
	}


	public OrganizationDto getOrganization() {
		return organization;
	}


	public void setOrganization(OrganizationDto organization) {
		this.organization = organization;
	}


	private Float height;

	
	private Float weight;

	
	private OrganizationDto organization;

}
