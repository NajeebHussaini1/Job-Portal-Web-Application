package com.cgi.topjobs.api.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.topjobs.api.resume.dao.model.EmployeeShortListedCandidates;
import com.cgi.topjobs.api.resume.dto.model.EmployeesShortlisted;
import com.cgi.topjobs.api.resume.dto.model.Resume;
import com.cgi.topjobs.api.resume.services.ResumeServiceImpl;

/* Adding annotation to declare this class as REST Controller */
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ResumeController {

	@Autowired
	private ResumeServiceImpl service;

	public ResumeController(ResumeServiceImpl service) {
		this.service = service;
	}

	/* This method will create resume and return createdResume Object */

	@PostMapping("/resume/create")
	public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
		Resume createdResume = service.createResume(resume);
		return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
	}
	/* This method should fetch all resumes and return the list of all resumes */

	@GetMapping("/resumes")
	public ResponseEntity<List<Resume>> getAllResumes() {
		return new ResponseEntity<List<Resume>>((List<Resume>) service.getAllResumes(), HttpStatus.OK);
	}

	/* should search resume by job id */

	@GetMapping("/resume/search/{JobId}")
	public ResponseEntity<List<EmployeeShortListedCandidates> > getResumesByJobId(@PathVariable("JobId") Integer id) {
		return new ResponseEntity<List<EmployeeShortListedCandidates> >(service.getResumesByJobId(id), HttpStatus.FOUND);
	}

	/* get resume by resume id */
	@GetMapping("/resume/search/resumes/{ResumeId}")
	public ResponseEntity<Resume> getResumesByResumeId(@PathVariable("ResumeId") String id) {
		return new ResponseEntity<>(service.getResumesByResumeId(id), HttpStatus.FOUND);
	}

	@PostMapping("/resume/shortlist")
	public ResponseEntity<EmployeesShortlisted> shortListResume(@RequestBody EmployeesShortlisted shortListedResume) {
		EmployeesShortlisted shortListedResumes = service.shortListResume(shortListedResume);
		return new ResponseEntity<>(shortListedResumes, HttpStatus.OK);

	}

	@GetMapping("/resume/shortlist/resumes")
	public ResponseEntity<List<EmployeeShortListedCandidates>> getShortListResumes() {
		return new ResponseEntity<>(service.getShortlistedPeople(), HttpStatus.OK);
	}
}
