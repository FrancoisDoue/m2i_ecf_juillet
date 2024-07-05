package com.example.ecf_recrutement.repository;

import com.example.ecf_recrutement.model.RecruiterAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterAccountRepository extends JpaRepository<RecruiterAccount, Integer> {
    RecruiterAccount findByLogin(String login);
}
