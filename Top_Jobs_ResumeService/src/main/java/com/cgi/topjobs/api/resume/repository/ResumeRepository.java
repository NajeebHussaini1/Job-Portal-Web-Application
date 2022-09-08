package com.cgi.topjobs.api.resume.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.topjobs.api.resume.dao.model.Resumes;


@Repository
public interface ResumeRepository extends MongoRepository<Resumes, String> {

}



