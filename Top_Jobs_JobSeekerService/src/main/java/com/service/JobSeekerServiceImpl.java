package com.service;

import com.model.JobSeeker;
import com.repo.JobSeekerRepository;
import com.security.HashFunction;
import com.shared.JobSeekerDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {


    JobSeekerRepository jobSeekerRepository;

    @Autowired
    public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }


    @Override
    public JobSeekerDto createJobSeeker(JobSeekerDto jobSeekerDetails) {
        jobSeekerDetails.setUserId(UUID.randomUUID().toString());
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        md.update(jobSeekerDetails.getPassword().getBytes());
        byte[] bytesOfHashedString = md.digest();
        jobSeekerDetails.setPassword(HashFunction.decToHex(bytesOfHashedString));
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        JobSeeker jobSeeker = mapper.map(jobSeekerDetails, JobSeeker.class);
        jobSeekerRepository.save(jobSeeker);

        return mapper.map(jobSeeker, JobSeekerDto.class);
    }

    @Override
    public JobSeekerDto deleteJobSeeker(Integer id) {
        JobSeekerDto deletedJobSeeker = null;
        Optional<JobSeeker> optional = jobSeekerRepository.findById(id);
        if (optional.isPresent()) {
            ModelMapper mapper= new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            JobSeeker jobSeeker = optional.get();
            deletedJobSeeker = mapper.map(jobSeeker, JobSeekerDto.class);
            jobSeekerRepository.deleteById(id);
        }
        return deletedJobSeeker;
    }

    @Override
    public JobSeekerDto updateJobSeeker(Integer id, String email) {
        JobSeekerDto updatedJobSeeker = null;
        Optional<JobSeeker> optional = jobSeekerRepository.findById(id);
        if (optional.isPresent()) {
            ModelMapper mapper= new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            JobSeeker jobSeeker = optional.get();
            jobSeeker.setEmail(email);
            jobSeekerRepository.save(jobSeeker);
            updatedJobSeeker = mapper.map(jobSeeker, JobSeekerDto.class);
        }

        return updatedJobSeeker;
    }


    @Override
    public List<JobSeeker> getJobSeekers() {
        List<JobSeeker> jobSeekers = (List<JobSeeker>) jobSeekerRepository.findAll();
        return jobSeekers;
    }

    @Override
    public boolean validate(String email, String password) {

        if (email == null || password == null) {
            return false;
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] bytesOfHashedString = md.digest();
        if (jobSeekerRepository.validate(email, HashFunction.decToHex(bytesOfHashedString)) != null) {
            return true;
        }
        return false;
    }


}
