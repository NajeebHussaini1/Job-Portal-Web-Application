package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Job;

@Repository
public interface JobRepository extends MongoRepository<Job, Integer>{

}
