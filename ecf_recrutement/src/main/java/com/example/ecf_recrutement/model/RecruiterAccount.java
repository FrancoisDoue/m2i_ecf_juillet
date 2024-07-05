package com.example.ecf_recrutement.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity @Table(name = "account")
public class RecruiterAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull @Column(unique = true, nullable = false)
    private String login;
    @NonNull @Column(nullable = false)
    private String password;

}
