package com.united.healthcare.domain.request;

public class EnrolleeRequest {

	private String enrolleeName;

	private String dateOfBirth;

	private boolean activationStatus;

	private String phoneNumber;
	
	private Long id;

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

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EnrolleeRequest [enrolleeName=" + enrolleeName + ", dateOfBirth=" + dateOfBirth + ", activationStatus="
				+ activationStatus + ", phoneNumber=" + phoneNumber + ", id=" + id + "]";
	}

}
