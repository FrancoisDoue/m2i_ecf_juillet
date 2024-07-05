package com.example.ecf_recrutement.repository;

import com.example.ecf_recrutement.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {
}
