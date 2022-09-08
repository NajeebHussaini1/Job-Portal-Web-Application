package com.controller;

import com.model.Admins;
import com.service.AdminsService;
import com.shared.AdminsDto;
import com.ui.model.CreateAdminsRequestModel;
import com.ui.model.CreateAdminsResponseModel;
import com.ui.model.LoginRequestModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminsAuthController {


    AdminsService service;

    @Autowired
    public AdminsAuthController(AdminsService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("admin")
    public ResponseEntity<CreateAdminsResponseModel> createAdmin(@RequestBody CreateAdminsRequestModel createAdminsRequestModel) {
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AdminsDto adminsDto = mapper.map(createAdminsRequestModel, AdminsDto.class);

        AdminsDto createdAdmin = service.createAdmin(adminsDto);
        CreateAdminsResponseModel returnValue = mapper.map(createdAdmin, CreateAdminsResponseModel.class);

        return  ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("login")
    public  ResponseEntity<?> login(@RequestBody LoginRequestModel user) throws Exception{

        String jwtToken = "";
        Map<String,String> map = new HashMap<>();
        try {
            jwtToken = getToken(user.getEmail(), user.getPassword());
            map.put("message","Admin logged in");
            map.put("token",jwtToken);
            List<Admins> admins = service.getAdmins();
            for(Admins admin : admins) {
                if (admin.getEmail().equalsIgnoreCase(user.getEmail())) {
                    map.put("id", admin.getId().toString());
                    map.put("firstName", admin.getFirstName());
                    map.put("lastName", admin.getLastName());
                    map.put("email", admin.getEmail());
                }
            }
        } catch(Exception e) {
            map.clear();
            map.put("message","Admin unable to log in");
            map.put("token",null);
        }

        if (map.containsValue(null)) {
            return new ResponseEntity<Map>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map>(map, HttpStatus.OK);


    }

    public String getToken(String username,String password) throws Exception {

        String jwtToken = "";

        if(username == null || password ==null) {
            throw new ServletException("Username - Password - blank");
        }

        boolean status = service.validate(username, password);

        if(!status) {
            throw new ServletException("Invalid credentials");
        }

        jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .signWith(SignatureAlgorithm.HS256, "ustglobal")
                .compact();

        return jwtToken;

    }

}
