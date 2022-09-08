package com.controller;

import com.model.JobSeeker;
import com.service.JobSeekerService;
import com.shared.JobSeekerDto;
import com.ui.model.CreateJobSeekerRequestModel;
import com.ui.model.CreateJobSeekerResponseModel;
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
public class JobSeekerAuthController {

    @Autowired
    JobSeekerService jobSeekerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("jobseeker")
    public ResponseEntity<CreateJobSeekerResponseModel> createJobSeeker(@RequestBody CreateJobSeekerRequestModel createJobSeekerRequestModel) {
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        JobSeekerDto jobSeekerDto = mapper.map(createJobSeekerRequestModel, JobSeekerDto.class);

        JobSeekerDto createdJobSeeker = jobSeekerService.createJobSeeker(jobSeekerDto);
        CreateJobSeekerResponseModel returnValue = mapper.map(createdJobSeeker, CreateJobSeekerResponseModel.class);

        return  ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("login")
    public  ResponseEntity<?> login(@RequestBody LoginRequestModel user) throws Exception{

        String jwtToken = "";
        Map<String,String> map = new HashMap<>();
        try {
            jwtToken = getToken(user.getEmail(), user.getPassword());
            map.put("message","JobSeeker logged in");
            map.put("token",jwtToken);
            List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekers();
            for(JobSeeker jobSeeker : jobSeekers) {
                if (jobSeeker.getEmail().equalsIgnoreCase(user.getEmail())) {
                    map.put("id", jobSeeker.getId().toString() );
                    map.put("userName", jobSeeker.getUserName() );
                    map.put("email", jobSeeker.getEmail() );
                    map.put("firstName", jobSeeker.getFirstName());
                    map.put("lastName", jobSeeker.getLastName());
                    map.put("phoneNumber", jobSeeker.getPhoneNumber());
                    map.put("city", jobSeeker.getCity());
                    map.put("province" , jobSeeker.getProvince());
                    map.put("gender", jobSeeker.getGender());
                }
            }
        } catch(Exception e) {
            map.clear();
            map.put("message","JobSeeker unable to log in");
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

        boolean status = jobSeekerService.validate(username, password);

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
