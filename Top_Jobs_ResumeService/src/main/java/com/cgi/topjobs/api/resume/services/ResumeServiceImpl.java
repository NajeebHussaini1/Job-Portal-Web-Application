package com.cgi.topjobs.api.resume.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cgi.topjobs.api.resume.model.mapper.ResumeShortlistedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.topjobs.api.resume.dao.model.EmployeeShortListedCandidates;
import com.cgi.topjobs.api.resume.dao.model.Resumes;
import com.cgi.topjobs.api.resume.dto.model.EmployeesShortlisted;
import com.cgi.topjobs.api.resume.dto.model.Resume;
import com.cgi.topjobs.api.resume.exceptions.ResumeNotFoundException;
import com.cgi.topjobs.api.resume.model.mapper.ResumeMapper;
import com.cgi.topjobs.api.resume.repository.ResumeRepository;
import com.cgi.topjobs.api.resume.repository.ShorlistedCandidatesRepository;

@Service
public class ResumeServiceImpl implements ResumeService {
	

	ResumeMapper mapper;


	ResumeShortlistedMapper shortlistedMapper;
	
	private ResumeRepository resumerepo;
	
	private ShorlistedCandidatesRepository shorlistedCandidates;

	@Autowired
	public ResumeServiceImpl(ResumeMapper mapper, ResumeShortlistedMapper shortlistedMapper, ResumeRepository resumerepo, ShorlistedCandidatesRepository shorlistedCandidates) {
		this.mapper = mapper;
		this.shortlistedMapper = shortlistedMapper;
		this.resumerepo = resumerepo;
		this.shorlistedCandidates = shorlistedCandidates;
	}

	@Override
	public Resume createResume(Resume resume) {
		Resumes resumes =mapper.mapResumeDtoToDao(resume);
		Resumes resumeDaoObject = resumerepo.save(resumes);
		return mapper.mapResumeDaoToDto(resumeDaoObject);
	}

	@Override
	public List<Resume> getAllResumes() {
		List<Resume> resumeOfList = new ArrayList<>();
		 for(Resumes resumes:(List<Resumes>) resumerepo.findAll()){
			 resumeOfList.add(mapper.mapResumeDaoToDto(resumes));
		 }
		 return resumeOfList;
	}

	@Override
	public Resume getResumesByResumeId(String id) {
		Optional<Resumes> resumeDaoObject = resumerepo.findById(id);
		if(resumeDaoObject.isPresent()) {
		return mapper.mapResumeDaoToDto(resumeDaoObject.get());
		}
		else {
			throw new ResumeNotFoundException ("Not Found Resume with Id"+id);
		}
	}

	@Override
	public List<EmployeeShortListedCandidates> getResumesByJobId(Integer JobId) {
		List<EmployeeShortListedCandidates> shortListedCanidates= shorlistedCandidates.findByJobId(JobId);
		return shortListedCanidates;
	}

	@Override
	public EmployeesShortlisted shortListResume(EmployeesShortlisted shortListedResume ) {

		EmployeeShortListedCandidates employeeShortListedCandidates = shorlistedCandidates.save(shortlistedMapper.mapShortlistedResumesDtoToDao(shortListedResume));
		return shortlistedMapper.mapShortlistedResumesDaoToDto(employeeShortListedCandidates);
	}

	@Override
	public List<EmployeeShortListedCandidates> getShortlistedPeople() {
		return (List<EmployeeShortListedCandidates>) shorlistedCandidates.findAll();
	}


}
