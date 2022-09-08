package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appliedJobs")
public class AppliedJob {

    @Id
    private Integer jobID;
    private Integer candidateID;
    private String resumeID;
    private String userName;
    private String email;

    public AppliedJob() {
        super();
    }

    public AppliedJob(Integer jobID, Integer candidateID, String resumeID, String userName, String email) {
        this.jobID = jobID;
        this.candidateID = candidateID;
        this.resumeID = resumeID;
        this.userName = userName;
        this.email = email;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public Integer getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Integer candidateID) {
        this.candidateID = candidateID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResumeID() {
        return resumeID;
    }

    public void setResumeID(String resumeID) {
        this.resumeID = resumeID;
    }
}
