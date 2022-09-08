package com.controller;

import com.model.JobSeeker;
import com.service.JobSeekerService;
import com.shared.JobSeekerDto;
import com.ui.model.CreateJobSeekerRequestModel;
import com.ui.model.CreateJobSeekerResponseModel;
import com.ui.model.UpdateJobSeekerRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobSeekerController {

    @Autowired
    JobSeekerService jobSeekerService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/jobseekers")
    public ResponseEntity<List<JobSeeker>> loadEmployers() {
        return ResponseEntity.status(HttpStatus.FOUND).body(jobSeekerService.getJobSeekers());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CreateJobSeekerResponseModel> deleteEmployer(@PathVariable Integer id) {
        JobSeekerDto jobSeekerDto = jobSeekerService.deleteJobSeeker(id);
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (jobSeekerDto != null) {
            CreateJobSeekerResponseModel returnValue = mapper.map(jobSeekerDto, CreateJobSeekerResponseModel.class);
            return  ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateJobSeekerResponseModel());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public ResponseEntity<CreateJobSeekerResponseModel> updateEmployer(@RequestBody UpdateJobSeekerRequestModel updateJobSeekerRequestModel) {
        JobSeekerDto employerDto = jobSeekerService.updateJobSeeker(updateJobSeekerRequestModel.getId(), updateJobSeekerRequestModel.getEmail());
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (employerDto != null) {
            CreateJobSeekerResponseModel returnValue = mapper.map(employerDto, CreateJobSeekerResponseModel.class);
            return  ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateJobSeekerResponseModel());
        }
    }

}
