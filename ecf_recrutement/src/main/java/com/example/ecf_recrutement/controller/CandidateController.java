package com.example.ecf_recrutement.controller;

import com.example.ecf_recrutement.model.JobApplication;
import com.example.ecf_recrutement.model.JobOffer;
import com.example.ecf_recrutement.service.JobApplicationService;
import com.example.ecf_recrutement.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CandidateController {

    private final JobOfferService jobOfferService;
    private final JobApplicationService jobApplicationService;

    @Autowired
    public CandidateController(JobOfferService jobOfferService, JobApplicationService jobApplicationService) {
        this.jobOfferService = jobOfferService;
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping
    public String indexAndJobsOfferList(Model model) {
        model.addAttribute("jobOffers", jobOfferService.getAllJobOffers());
        return "index";
    }

    @GetMapping("/job/{id}")
    public String jobOffer(@PathVariable int id, Model model) {
        JobOffer jobOffer = jobOfferService.getJobOfferById(id);
        model.addAttribute("jobOffer", jobOffer);
        model.addAttribute("apply", new JobApplication());
        return "job-detail";
    }

    @PostMapping("/job/{id}")
    public String applyJob(@PathVariable int id, JobApplication jobApplication) {
        jobApplicationService.save(jobOfferService.getJobOfferById(id), jobApplication);
        return "redirect:/job";
    }



}
