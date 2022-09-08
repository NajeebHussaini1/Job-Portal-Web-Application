package com.repo;

import com.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    @Query(value = "select * from employer where email=?1 and password=?2", nativeQuery = true)
    Employer validate(String email, String password);
}
