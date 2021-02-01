package com.united.healthcare.domain.request;

public class DependentRequest {

	private String enrolleeName;

	private String dateOfBirth;

	private Long id;

	private Long enrolleeId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(Long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	@Override
	public String toString() {
		return "DependentRequest [enrolleeName=" + enrolleeName + ", dateOfBirth=" + dateOfBirth + ", id=" + id
				+ ", enrolleeId=" + enrolleeId + "]";
	}	

}
