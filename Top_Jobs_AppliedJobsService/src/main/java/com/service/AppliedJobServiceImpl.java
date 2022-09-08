package com.service;

import com.model.AppliedJob;
import com.repo.AppliedJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppliedJobServiceImpl implements AppliedJobService {

    private AppliedJobRepository appliedJobRepository;

    @Autowired
    public AppliedJobServiceImpl(AppliedJobRepository appliedJobRepository) {
        this.appliedJobRepository = appliedJobRepository;
    }

    @Override
    public AppliedJob createAppliedJob(AppliedJob appliedJob) {
        return appliedJobRepository.save(appliedJob);
    }

    @Override
    public List<AppliedJob> getAppliedJobs() {
        return (List<AppliedJob>) appliedJobRepository.findAll();
    }

    @Override
    public AppliedJob getAppliedJobById(Integer id) {
        AppliedJob returnJob = null;
        Optional<AppliedJob> optional = appliedJobRepository.findById(id);
        if (optional.isPresent()) {
            returnJob = optional.get();
        }

        return returnJob;
    }

    @Override
    public AppliedJob deleteAppliedJob(Integer id) {
        AppliedJob returnJob = null;
        Optional<AppliedJob> optional = appliedJobRepository.findById(id);
        if (optional.isPresent()) {
            returnJob = optional.get();
            appliedJobRepository.deleteById(id);
        }

        return returnJob;
    }
}
