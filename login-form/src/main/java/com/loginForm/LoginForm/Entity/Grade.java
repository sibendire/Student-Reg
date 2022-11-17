package com.loginForm.LoginForm.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
    @Column(name = "subject")
private String subjects;
    @Column(name = "Eng")
private String English;
    @Column(name = "chem")
private String chemistry;
    @Column(name = "phy")
private String physics;
    @Column(name = "bios")
private String biology;
    @Column(name = "agric")
private String agriculture;
    @Column(name = "comm")
private String commerce;
    @Column(name = "history")
private String history;
    @Column(name = "CRE")
private String cre;
    @Column(name = "geo")
private String geography;
    @Column(name = "ict")
private String computer;
    @Column(name = "swahili")
private String kiswahili;
    @Column(name = "French")
private String french;
    @Column(name = "Fart")
private String fineArt;
    @Column(name = "Ent")
private String entrepreneurship;
    @Column(name = "Lit")
private String literature;
    @Column(name = "Marths")
private String mathematics;
    @Column(name = "building")
    private String building;

}
