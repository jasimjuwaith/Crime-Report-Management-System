package com.wipro.crms.entity;

public class CrimeCase {
	private String caseID;
	private String crimeType;
	private String description;
	private String status;
	 
	public CrimeCase(String caseID, String crimeType, String description, String status) {
		super();
		this.caseID = caseID;
		this.crimeType = crimeType;
		this.description = description;
		this.status = status;
	}
	public String getCaseID(){
		
		return caseID;
	}

	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
