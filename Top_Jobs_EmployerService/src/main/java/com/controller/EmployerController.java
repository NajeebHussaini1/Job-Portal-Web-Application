package com.controller;

import com.model.Employer;
import com.service.EmployerService;
import com.shared.EmployerDto;
import com.ui.model.CreateEmployerRequestModel;
import com.ui.model.CreateEmployerResponseModel;
import com.ui.model.UpdateEmployerRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employers")
    public ResponseEntity<List<Employer>> loadEmployers() {
        return ResponseEntity.status(HttpStatus.FOUND).body(employerService.getEmployers());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO EMPLOYER SERVICE APP";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CreateEmployerResponseModel> deleteEmployer(@PathVariable Integer id) {
        EmployerDto employerDto = employerService.deleteEmployer(id);
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (employerDto != null) {
            CreateEmployerResponseModel returnValue = mapper.map(employerDto, CreateEmployerResponseModel.class);
            return  ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateEmployerResponseModel());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public ResponseEntity<CreateEmployerResponseModel> updateEmployer(@RequestBody UpdateEmployerRequestModel updateEmployerRequestModel) {
        EmployerDto employerDto = employerService.updateEmployer(updateEmployerRequestModel.getId(), updateEmployerRequestModel.getEmail());
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (employerDto != null) {
            CreateEmployerResponseModel returnValue = mapper.map(employerDto, CreateEmployerResponseModel.class);
            return  ResponseEntity.status(HttpStatus.OK).body(returnValue);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateEmployerResponseModel());
        }
    }

}
