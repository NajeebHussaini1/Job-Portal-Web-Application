package com.service;


import com.model.Employer;
import com.shared.EmployerDto;

import java.util.List;

public interface EmployerService {
    EmployerDto createEmployer(EmployerDto employerDetails);
    EmployerDto deleteEmployer(Integer id);
    EmployerDto updateEmployer(Integer id, String email);
    List<Employer> getEmployers();
    boolean validate(String email,String password);

}
