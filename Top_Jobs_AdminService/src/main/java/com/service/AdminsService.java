package com.service;

import com.model.Admins;
import com.shared.AdminsDto;

import java.util.List;

public interface AdminsService {

    AdminsDto createAdmin(AdminsDto adminDetails);
    AdminsDto deleteAdmin(Integer id);
    AdminsDto updateAdmin(Integer id, String email);
    List<Admins> getAdmins();
    boolean validate(String email,String password);

}
