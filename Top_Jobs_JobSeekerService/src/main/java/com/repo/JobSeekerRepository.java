package com.repo;

import com.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

    @Query(value = "select * from job_seeker where email=?1 and password=?2", nativeQuery = true)
    JobSeeker validate(String email, String password);

}
