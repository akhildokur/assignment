package com.united.healthcare.domain.response;

import java.util.List;

import com.united.healthcare.domain.dto.Dependent;

public class EnrolleeResponse {

	private Long id;

	private String enrolleeName;

	private String dateOfBirth;

	private boolean activationStatus;

	private String phoneNumber;

	private List<Dependent> dependents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnrolleeName() {
		return enrolleeName;
	}

	public void setEnrolleeName(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String string) {
		this.phoneNumber = string;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	@Override
	public String toString() {
		return "EnrolleeResponse [id=" + id + ", enrolleeName=" + enrolleeName + ", dateOfBirth=" + dateOfBirth
				+ ", activationStatus=" + activationStatus + ", phoneNumber=" + phoneNumber + ", dependents="
				+ dependents + "]";
	}

}
