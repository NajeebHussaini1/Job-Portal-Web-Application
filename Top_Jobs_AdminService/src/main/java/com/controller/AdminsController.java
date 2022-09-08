package com.controller;

import com.model.Admins;
import com.service.AdminsService;
import com.shared.AdminsDto;
import com.ui.model.CreateAdminsRequestModel;
import com.ui.model.CreateAdminsResponseModel;
import com.ui.model.UpdateAdminsRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminsController {

    @Autowired
    AdminsService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admins")
    public ResponseEntity<List<Admins>> loadAdmins() {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getAdmins());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO Admin SERVICE APP";
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CreateAdminsResponseModel> deleteAdmin(@PathVariable Integer id) {
        AdminsDto adminsDto = service.deleteAdmin(id);
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (adminsDto != null) {
            CreateAdminsResponseModel returnValue = mapper.map(adminsDto, CreateAdminsResponseModel.class);
            return  ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateAdminsResponseModel());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public ResponseEntity<CreateAdminsResponseModel> updateEmployer(@RequestBody UpdateAdminsRequestModel updateAdminsRequestModel) {
        AdminsDto adminsDto = service.updateAdmin(updateAdminsRequestModel.getId(), updateAdminsRequestModel.getEmail());
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (adminsDto != null) {
            CreateAdminsResponseModel returnValue = mapper.map(adminsDto, CreateAdminsResponseModel.class);
            return  ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateAdminsResponseModel());
        }
    }





}
