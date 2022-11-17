package com.loginForm.LoginForm.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sponsor")
public class SponsorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String NIN;
    private String Email;
    private int phone;
    private String occupation;
    private String address;





}
