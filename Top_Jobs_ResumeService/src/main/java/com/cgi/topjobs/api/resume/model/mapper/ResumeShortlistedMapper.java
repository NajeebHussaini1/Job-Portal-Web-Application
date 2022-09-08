package com.cgi.topjobs.api.resume.model.mapper;

import com.cgi.topjobs.api.resume.dao.model.EmployeeShortListedCandidates;
import com.cgi.topjobs.api.resume.dto.model.EmployeesShortlisted;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResumeShortlistedMapper {

	public EmployeeShortListedCandidates mapShortlistedResumesDtoToDao(EmployeesShortlisted shortListed) {
		EmployeeShortListedCandidates shortList = new EmployeeShortListedCandidates();
		shortList.setEmployerId(shortListed.getEmployerId());
		shortList.setJobId(shortListed.getJobId());
		shortList.setResumeId(shortListed.getResumeId());
		return shortList;
	}
	
	
	public EmployeesShortlisted mapShortlistedResumesDaoToDto(EmployeeShortListedCandidates employeeShortListed) {
		EmployeesShortlisted employeesShortlisted = new EmployeesShortlisted();
		employeesShortlisted.setEmployerId(employeeShortListed.getEmployerId());
		employeesShortlisted.setJobId(employeeShortListed.getJobId());
		employeesShortlisted.setResumeId(employeeShortListed.getResumeId());
		return employeesShortlisted;
	}
	
	
	
}
