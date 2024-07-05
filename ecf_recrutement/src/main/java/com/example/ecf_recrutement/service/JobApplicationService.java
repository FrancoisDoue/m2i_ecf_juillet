package com.example.ecf_recrutement.service;

import com.example.ecf_recrutement.model.JobApplication;
import com.example.ecf_recrutement.model.JobOffer;
import com.example.ecf_recrutement.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public JobApplication save(JobOffer jobOffer, JobApplication jobApplication) {
        jobApplication.setJobOffer(jobOffer);
        return jobApplicationRepository.save(jobApplication);
    }
}
