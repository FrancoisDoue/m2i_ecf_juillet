package com.example.ecf_recrutement.controller;

import com.example.ecf_recrutement.model.RecruiterAccount;
import com.example.ecf_recrutement.service.AuthService;
import com.example.ecf_recrutement.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {

    private final AuthService authService;
    private final JobOfferService jobOfferService;

    @Autowired
    public RecruiterController(AuthService authService, JobOfferService jobOfferService) {
        this.authService = authService;
        this.jobOfferService = jobOfferService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (authService.isLogged()) return "redirect:/recruiter/home";
        model.addAttribute("recruiterAccount", new RecruiterAccount());
        return "recruiter-login";
    }

    @PostMapping("/login")
    public String loginPost(RecruiterAccount recruiterAccount) {
        authService.login(recruiterAccount);
        if (authService.isLogged()) return "redirect:/recruiter/home";
        return "redirect:/recruiter/login";
    }

    @GetMapping("/logout")
    public String logout() {
        authService.logout();
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!authService.isLogged()) return "redirect:/recruiter/login";
        model.addAttribute("offers", jobOfferService.getAllJobOffers());
        return "recruiter-home";
    }

}
