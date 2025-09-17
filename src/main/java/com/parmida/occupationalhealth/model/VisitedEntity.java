package com.parmida.occupationalhealth.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;
import com.parmida.occupationalhealth.common.enumeration.Gender;
import com.parmida.occupationalhealth.common.enumeration.MarridationStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "VISTEDS", indexes = {
		@Index(columnList = "ID_ORGANIZATION")}, uniqueConstraints = { @UniqueConstraint(columnNames = "NATIONAL_ID") })

public class VisitedEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "NATIONAL_ID")
	private String nationalId;

	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "BIRTHDAY")
	private Long birthday;

	@Column(name = "JOB")
	private String job;

	@Column(name = "EDUCATION")
	private String education;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "MARRIDATION_STATUS")
	@Enumerated(EnumType.STRING)
	private MarridationStatus marridationStatus;

	@Column(name = "CHILDCOUNT")
	private Integer childCount;

	@Column(name = "ETHNICITY")
	private String ethnicity;

	@Column(name = "HEIGHT")
	private Float height;

	@Column(name = "WEIGHT")
	private Float weight;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_ORGANIZATION")
	private Organization organization;

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

	public MarridationStatus getMarridationStatus() {
		return marridationStatus;
	}

	public void setMarridationStatus(MarridationStatus marridationStatus) {
		this.marridationStatus = marridationStatus;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
