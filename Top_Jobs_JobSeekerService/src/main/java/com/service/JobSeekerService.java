package com.service;


import com.model.JobSeeker;
import com.shared.JobSeekerDto;


import java.util.List;

public interface JobSeekerService {
    JobSeekerDto createJobSeeker(JobSeekerDto jobSeekerDetails);
    JobSeekerDto deleteJobSeeker(Integer id);
    JobSeekerDto updateJobSeeker(Integer id, String email);
    List<JobSeeker> getJobSeekers();
    boolean validate(String email,String password);
}
