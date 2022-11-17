package com.loginForm.LoginForm.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TeachersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "other_Name")
    private String otherName;
    @Column(name = "NIN")
    private String NIN;
    @Column(name = "Email")
    private String Email;
    @Column(name = "phone")
    private int phone;
    @Column(name = "address")
    private String address;
    @Column(name = "DateOfBirth")
    private String DateOfBirth;
    @Column(name = "Nationality")
    private String Nationality;
    @Column(name = "subjects")
    private String subjects;
    @Column(name = "departments")
    private String departments;

}
