package com.loginForm.LoginForm.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Registration")
public class RegisterStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String otherName;
    private  String DateOfBirth;
    private String Gender;
    private String Religion;
    private String HealthStatus;
    private String level;
    private String formerSchool;
    private String previousGrade;
    private String nationality;
    private String country;
    private String homeDistrict;
    private String subCounty;
    private String parish;
    private String village;


}
