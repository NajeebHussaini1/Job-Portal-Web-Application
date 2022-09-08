package com.service;

import com.model.AppliedJob;

import java.util.List;

public interface AppliedJobService {
    AppliedJob createAppliedJob(AppliedJob appliedJob);
    List<AppliedJob> getAppliedJobs();
    AppliedJob getAppliedJobById(Integer id);
    AppliedJob deleteAppliedJob(Integer id);
}
