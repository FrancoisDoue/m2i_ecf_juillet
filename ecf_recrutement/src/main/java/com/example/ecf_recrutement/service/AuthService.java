package com.example.ecf_recrutement.service;

import com.example.ecf_recrutement.model.RecruiterAccount;
import com.example.ecf_recrutement.repository.RecruiterAccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final HttpSession session;
    private final RecruiterAccountRepository repository;

    @Autowired
    public AuthService(HttpSession session, RecruiterAccountRepository repository) {
        this.session = session;
        this.repository = repository;
    }

    public void login(RecruiterAccount recruiterAccount) {
        boolean isValidCredentials = repository.findByLogin(recruiterAccount.getLogin()).getPassword().equals(recruiterAccount.getPassword());
        if (isValidCredentials)
            session.setAttribute("account", recruiterAccount);
    }

    public void logout() {
        if (session.getAttribute("account") != null)
            session.removeAttribute("account");
    }

    public boolean isLogged() {
        return session.getAttribute("account") != null && session.getAttribute("account") instanceof RecruiterAccount;
    }
}
