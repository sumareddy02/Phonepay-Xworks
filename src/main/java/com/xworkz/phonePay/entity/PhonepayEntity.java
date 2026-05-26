package com.xworkz.phonePay.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Registration")

@NamedQuery(
        name = "findAllUsers",
        query = "SELECT r FROM PhonepayEntity r"
)
public class PhonepayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="Fname")
    private String fname;
    @Column(name = "Lname")
    private String lname;
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name="emailID")
    private String emailID;
    @Column(name="Password")
    private String Password;
}
