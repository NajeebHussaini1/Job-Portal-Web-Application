package com.controller;

import com.model.AppliedJob;
import com.service.AppliedJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class AppliedJobController {

    @Autowired
    AppliedJobService appliedJobService;

    @PostMapping("/addjob")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AppliedJob> addAppliedJob(@RequestBody AppliedJob appliedJob) {
        AppliedJob returnValue = appliedJobService.createAppliedJob(appliedJob);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/alljobs")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<AppliedJob>> getAllJobs() {
        return new ResponseEntity<>(appliedJobService.getAppliedJobs(), HttpStatus.OK);
    }

    @GetMapping("/job/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AppliedJob> getSpecificJob(@PathVariable("id") Integer id) {
        AppliedJob returnValue = appliedJobService.getAppliedJobById(id);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AppliedJob> deleteJob(@PathVariable("id") Integer id) {
        AppliedJob returnValue = appliedJobService.deleteAppliedJob(id);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
        }
    }


}
