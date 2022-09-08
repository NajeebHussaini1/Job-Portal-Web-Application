package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class Job {

	@Id
    /**
     * @Id annotation makes id variable as Primary key
     */
    private Integer jobId;
	private int employerId;
	private Date postDate;
    private String companyName, jobTitle, jobType, jobCategory, jobDiscription;
    private String requiredSkills, requiredExperience;
   
	public Job() {
		super();
	}

	public Job(Integer jobId, int employerId, Date postDate, String companyName, String jobTitle,
			String jobType, String jobCategory, String jobDiscription, String requiredSkills,
			String requiredExperience) {
		super();
		this.jobId = jobId;
		this.employerId = employerId;
		this.postDate = postDate;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.jobCategory = jobCategory;
		this.jobDiscription = jobDiscription;
		this.requiredSkills = requiredSkills;
		this.requiredExperience = requiredExperience;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getJobDiscription() {
		return jobDiscription;
	}

	public void setJobDiscription(String jobDiscription) {
		this.jobDiscription = jobDiscription;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", employerId=" + employerId + ", postDate=" + postDate
				+ ", companyName=" + companyName + ", jobTitle=" + jobTitle + ", jobType=" + jobType + ", jobCategory="
				+ jobCategory + ", jobDiscription=" + jobDiscription + ", requiredSkills=" + requiredSkills
				+ ", requiredExperience=" + requiredExperience + "]";
	}
	
	
}
