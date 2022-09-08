package com.cgi.topjobs.api.resume.dto.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Experience {
	
	@NotEmpty
	private Date  startDate;
	@NotEmpty
	private Date  endDate;
	@NotEmpty
	private String technologies;
	@NotEmpty
	private String firmName;
	@NotEmpty
	private String designation;
	private int yearsOfExperience;
	@NotEmpty
	private String description;
	
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
