package com.example.ecf_recrutement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "job_offer")
public class JobOffer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "jobOffer")
    private List<JobApplication> jobApplications;
}
