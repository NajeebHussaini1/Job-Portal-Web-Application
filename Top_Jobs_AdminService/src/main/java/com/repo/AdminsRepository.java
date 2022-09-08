package com.repo;

import com.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AdminsRepository extends JpaRepository<Admins, Integer> {

    @Query(value = "select * from admins where email=?1 and password=?2", nativeQuery = true)
    Admins validate(String email, String password);
}
