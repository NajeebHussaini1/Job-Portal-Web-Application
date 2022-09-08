package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.jobIdNotFoundException;
import com.model.Job;
import com.service.JobService;

	
@RestController
@RequestMapping("/jobportal")
public class JobController {
		
	@Autowired
    JobService service;

	public JobController(JobService jobService) {
		super();
		this.service = jobService;
	}
	@PostMapping("/postjob")
	@CrossOrigin(origins = "http://localhost:4200" )
	public ResponseEntity<Job> postJob(@RequestBody Job jobPosting) {
		Job job = service.addJob(jobPosting);
		return new ResponseEntity<>(job, HttpStatus.CREATED);
	}

	@GetMapping("/getAllJobs")
	@CrossOrigin(origins = "http://localhost:4200" )
	public ResponseEntity<List<Job>> getAllJobs() {
		return new ResponseEntity<List<Job>>((List<Job>) service.getAllJobs(), HttpStatus.OK);
	}

	@GetMapping("/search/{JobId}")
	@CrossOrigin(origins = "http://localhost:4200" )
	public ResponseEntity<Job> getJobByJobId(@PathVariable("JobId") int id) throws jobIdNotFoundException {
		return new ResponseEntity<>(service.getJobById(id), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200" )
	public ResponseEntity<Job> deleteByJobId(@PathVariable("id") int id) {
		Job job = service.deleteJob(id);
        if (job != null) {
            return  ResponseEntity.status(HttpStatus.OK).body(job);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
	}

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200" )
    public ResponseEntity<Job> updateJob(@RequestBody Job jobPosting) {
    	Job job = service.updateJob(jobPosting);
        if (job != null) {
            return  ResponseEntity.status(HttpStatus.OK).body(job);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }	
}

