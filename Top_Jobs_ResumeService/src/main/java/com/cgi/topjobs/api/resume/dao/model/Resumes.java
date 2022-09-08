package com.cgi.topjobs.api.resume.dao.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cgi.topjobs.api.resume.dto.model.Experience;

@Document(collection = "resumes")
public class Resumes {
	
	@Id
	private String resumeId;
	private String firstName;
    private String lastName;
    private String primaryNumber;
    private String userName;
	private String email;
	private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    private String highestLevelOfEducation;
	private List<Experience> experiences ;

	public Resumes() {
		super();
	}

	public Resumes(String resumeId, String firstName, String lastName, String primaryNumber, String userName, String email, String addressLine1, String addressLine2, String country, String state, String city, String highestLevelOfEducation, List<Experience> experiences) {
		this.resumeId = resumeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryNumber = primaryNumber;
		this.userName = userName;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.country = country;
		this.state = state;
		this.city = city;
		this.highestLevelOfEducation = highestLevelOfEducation;
		this.experiences = experiences;
	}



	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHighestLevelOfEducation() {
		return highestLevelOfEducation;
	}
	public void setHighestLevelOfEducation(String highestLevelOfEducation) {
		this.highestLevelOfEducation = highestLevelOfEducation;
	}
	public List<Experience> getExperiences() {
		return experiences;
	}
	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

}


