package com.controller;

import com.model.Employer;
import com.service.EmployerService;
import com.shared.EmployerDto;
import com.ui.model.CreateEmployerRequestModel;
import com.ui.model.CreateEmployerResponseModel;
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
public class EmployerAuthController {

    @Autowired
    EmployerService employerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("employer")
    public ResponseEntity<CreateEmployerResponseModel> createEmployer(@RequestBody CreateEmployerRequestModel createEmployerRequestModel) {
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployerDto employerDto = mapper.map(createEmployerRequestModel, EmployerDto.class);

        EmployerDto createdEmployer = employerService.createEmployer(employerDto);
        CreateEmployerResponseModel returnValue = mapper.map(createdEmployer, CreateEmployerResponseModel.class);

        return  ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("login")
    public  ResponseEntity<?> login(@RequestBody LoginRequestModel user) throws Exception{

        String jwtToken = "";
        Map<String,String> map = new HashMap<>();
        try {
            jwtToken = getToken(user.getEmail(), user.getPassword());
            map.put("message","Employer logged in");
            map.put("token",jwtToken);
            List<Employer> employers = employerService.getEmployers();
            for(Employer employer : employers) {
                if (employer.getEmail().equalsIgnoreCase(user.getEmail())) {
                    map.put("id", employer.getId().toString());
                    map.put("email", employer.getEmail());
                    map.put("companyName", employer.getCompanyName());
                    map.put("category", employer.getCategory());
                    map.put("about", employer.getAbout());
                }
            }
        } catch(Exception e) {
            map.clear();
            map.put("message","Employer unable to log in");
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

        boolean status = employerService.validate(username, password);

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
