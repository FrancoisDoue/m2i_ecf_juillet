package com.example.ecf_recrutement.repository;

import com.example.ecf_recrutement.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
}
