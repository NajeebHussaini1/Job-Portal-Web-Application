package com.service;

import com.model.Employer;
import com.repo.EmployerRepository;
import com.security.HashFunction;
import com.shared.EmployerDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployerServiceimpl implements EmployerService {


    EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceimpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public EmployerDto createEmployer(EmployerDto employerDetails) {
        employerDetails.setEmployerId(UUID.randomUUID().toString());
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        md.update(employerDetails.getPassword().getBytes());
        byte[] bytesOfHashedString = md.digest();
        employerDetails.setPassword(HashFunction.decToHex(bytesOfHashedString));
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Employer employer = mapper.map(employerDetails, Employer.class);
        employerRepository.save(employer);

        return mapper.map(employer, EmployerDto.class);

    }

    @Override
    public EmployerDto deleteEmployer(Integer id) {
        EmployerDto deletedEmployer = null;
        Optional<Employer> optional = employerRepository.findById(id);
        if (optional.isPresent()) {
            ModelMapper mapper= new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Employer employer = optional.get();
            deletedEmployer =  mapper.map(employer, EmployerDto.class);
            employerRepository.deleteById(id);
        }

        return deletedEmployer;
    }

    @Override
    public EmployerDto updateEmployer(Integer id, String email) {
        EmployerDto updatedEmployer = null;
        Optional<Employer> optional = employerRepository.findById(id);
        if (optional.isPresent()) {
            ModelMapper mapper= new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Employer employer = optional.get();
            employer.setEmail(email);
            employerRepository.save(employer);
            updatedEmployer = mapper.map(employer, EmployerDto.class);
        }

        return updatedEmployer;
    }

    @Override
    public List<Employer> getEmployers() {
        List<Employer> employers = (List<Employer>) employerRepository.findAll();
        return employers;
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
        if (employerRepository.validate(email, HashFunction.decToHex(bytesOfHashedString)) != null) {
            return true;
        }
        return false;
    }

}
