package com.service;

import com.model.Admins;
import com.repo.AdminsRepository;
import com.security.HashFunction;
import com.shared.AdminsDto;
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
public class AdminsServiceImpl implements AdminsService {

    AdminsRepository adminsRepository;

    @Autowired
    public AdminsServiceImpl(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    @Override
    public AdminsDto createAdmin(AdminsDto adminDetails) {
        adminDetails.setAdminId(UUID.randomUUID().toString());
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        md.update(adminDetails.getPassword().getBytes());
        byte[] bytesOfHashedString = md.digest();
        adminDetails.setPassword(HashFunction.decToHex(bytesOfHashedString));
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Admins admins = mapper.map(adminDetails, Admins.class);
        adminsRepository.save(admins);

        return mapper.map(admins, AdminsDto.class);
    }

    @Override
    public AdminsDto deleteAdmin(Integer id) {
        AdminsDto deletedAdmin = null;
        Optional<Admins> optional = adminsRepository.findById(id);
        if (optional.isPresent()) {
            ModelMapper mapper= new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Admins admins = optional.get();
            deletedAdmin = mapper.map(admins, AdminsDto.class);
            adminsRepository.deleteById(id);
        }
        return deletedAdmin;
    }

    @Override
    public AdminsDto updateAdmin(Integer id, String email) {
        AdminsDto updatedAdmin = null;
        Optional<Admins> optional = adminsRepository.findById(id);
        if (optional.isPresent()) {
            ModelMapper mapper= new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Admins admins = optional.get();
            admins.setEmail(email);
            adminsRepository.save(admins);
            updatedAdmin = mapper.map(admins, AdminsDto.class);

        }
        return updatedAdmin;

    }

    @Override
    public List<Admins> getAdmins() {
        List<Admins> admins = (List<Admins>) adminsRepository.findAll();
        return admins;
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
        if (adminsRepository.validate(email, HashFunction.decToHex(bytesOfHashedString)) != null) {
            return true;
        }
        return false;
    }
}
