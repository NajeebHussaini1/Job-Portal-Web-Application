package com.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.jobIdNotFoundException;
import com.model.Job;
import com.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	
	private JobRepository jobRepository;
	
	/**
     * Constructor based Dependency injection to inject BlogRepository here
     */
    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

	@Override
	public Job addJob(Job job) {
		
        return jobRepository.save(job);
	}

	@Override
	public List<Job> getAllJobs() {
		return (List<Job>) jobRepository.findAll();
	}

	@Override
	public Job getJobById(int id) throws jobIdNotFoundException {
		Job job = jobRepository.findById(id).get();
		if (job == null) throw new jobIdNotFoundException();
		return job;
	}

	@Override
	public Job deleteJob(int id) {
		Job deletedJob = null;
        Optional<Job> optional = jobRepository.findById(id);
        if (optional.isPresent()) {
            deletedJob = optional.get();
            jobRepository.deleteById(id);
        }

        return deletedJob;
	}

	@Override
	public Job updateJob(Job job) {
		//Date date = job.getPostDate();
        Optional<Job> optional = jobRepository.findById(job.getJobId());
        if (optional.isPresent()) {
        	jobRepository.deleteById(job.getJobId());
            jobRepository.save(job);
        }
        return job;
	}

}
