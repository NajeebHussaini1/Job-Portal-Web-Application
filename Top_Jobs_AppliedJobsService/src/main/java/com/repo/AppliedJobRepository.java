package com.repo;

import com.model.AppliedJob;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliedJobRepository extends MongoRepository<AppliedJob, Integer> {
}
