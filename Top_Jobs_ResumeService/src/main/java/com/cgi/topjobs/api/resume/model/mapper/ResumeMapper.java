package com.cgi.topjobs.api.resume.model.mapper;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cgi.topjobs.api.resume.dao.model.Resumes;
import com.cgi.topjobs.api.resume.dto.model.Resume;

@Configuration
public class ResumeMapper {

	@Autowired
	ModelMapper mapper;

	public Resumes mapResumeDtoToDao(Resume resume) {
		mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		return mapper.map(resume, Resumes.class);

	}

	public Resume mapResumeDaoToDto(Resumes resumes) {
		return mapper.map(resumes, Resume.class);
	}

}
