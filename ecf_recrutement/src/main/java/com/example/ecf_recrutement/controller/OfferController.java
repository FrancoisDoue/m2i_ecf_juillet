package com.example.ecf_recrutement.controller;

import com.example.ecf_recrutement.model.JobOffer;
import com.example.ecf_recrutement.service.AuthService;
import com.example.ecf_recrutement.service.JobOfferService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final JobOfferService jobOfferService;
    private final AuthService authService;

    @Autowired
    public OfferController(JobOfferService jobOfferService, AuthService authService) {
        this.jobOfferService = jobOfferService;
        this.authService = authService;
    }

    @GetMapping
    public String offer(Model model) {
        if (!authService.isLogged()) return "redirect:/recruiter-login";
        model.addAttribute("offer", new JobOffer());
        return "job-form";
    }
    @PostMapping
    public String offerSubmit(@ModelAttribute("offer") JobOffer offer) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not yet implemented");
    }

}
