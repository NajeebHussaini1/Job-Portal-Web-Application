package com.cgi.topjobs.api.resume.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cgi.topjobs.api.resume.dao.model.EmployeeShortListedCandidates;

public interface ShorlistedCandidatesRepository extends MongoRepository<EmployeeShortListedCandidates, String>{


	@Query("{jobId:?0}")
	public List<EmployeeShortListedCandidates> findByJobId(Integer jobId);
	
	@Query("{jobId:?0, resumeId:?1}")
	public EmployeeShortListedCandidates findByJobAndResumeId(Integer jobId, String resumeId);

	
}
