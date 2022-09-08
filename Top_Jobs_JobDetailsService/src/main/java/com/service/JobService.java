package com.service;

import java.util.List;

import com.exception.jobIdNotFoundException;
import com.model.Job;

public interface JobService {
	/**
     * AbstractMethod to save a job
     */
    Job addJob(Job job);

    /**
     * AbstractMethod to get all jobs
     */
    List<Job> getAllJobs();

    /**
     * AbstractMethod to get job by id
     */
    Job getJobById(int id) throws jobIdNotFoundException;

    /**
     * AbstractMethod to delete job by id
     */
    Job deleteJob(int id);

    /**
     * AbstractMethod to update a job
     */
    Job updateJob(Job Job);

}
