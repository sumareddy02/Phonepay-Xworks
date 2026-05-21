package com.xworkz.phonePay.controller;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.service.PhonepayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhonepayController {

    @Autowired
    PhonepayService service;


    @GetMapping("/register")
    public String redirectToRegister(){
        System.out.println("Invoking redirectToTRegister.jsp");
        return "register.jsp";
    }

    @PostMapping("/create")
    public String registerUser( PhonepayDTO userDto) {


        System.out.println("invoking register user" + userDto);

        String serviceDTO=service.savePhonepayRegisterDTO(userDto);
        System.out.println("service dto saved  "+serviceDTO);

    /*   // Access DTO values
        String fname = userDto.getFname();
        String lname = userDto.getLname();
        String emailID = userDto.getEmailID();
        String password = userDto.getPassword();
        String mobileNumber = userDto.getMobileNumber();


        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Mobile Number: " + mobileNumber);*/

        return "success.jsp" ;
    }
}



