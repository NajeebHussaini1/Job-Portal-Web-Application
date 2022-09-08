package com.cgi.topjobs.api.resume.services;

import java.util.List;

import com.cgi.topjobs.api.resume.dao.model.EmployeeShortListedCandidates;
import com.cgi.topjobs.api.resume.dto.model.EmployeesShortlisted;
import com.cgi.topjobs.api.resume.dto.model.Resume;

public interface ResumeService {
	/**
	 * AbstractMethod to create a resume
	 */
	Resume createResume(Resume resume);

	/**
	 * AbstractMethod to get all resumes
	 */
	List<Resume> getAllResumes();

	/**
	 * AbstractMethod to get resumes by jobid
	 */
	List<EmployeeShortListedCandidates> getResumesByJobId(Integer id);

	/**
	 * AbstractMethod to get resumes by resume id
	 */
	Resume getResumesByResumeId(String id);

	/**
	 * AbstractMethod to shortlist resume
	 */
	public EmployeesShortlisted shortListResume(EmployeesShortlisted shortListedResume);

	List<EmployeeShortListedCandidates> getShortlistedPeople();

}



