package com.xworkz.phonePay.controller;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.entity.PhonepayEntity;
import com.xworkz.phonePay.service.PhonepayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collections;
import java.util.List;

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
    public String registerUser( PhonepayDTO userDto,Model model) {


        System.out.println("invoking register user" + userDto);

        String serviceDTO=service.savePhonepayRegisterDTO(userDto);
        System.out.println("service dto saved  "+serviceDTO);

        model.addAttribute("message",serviceDTO);

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

        return "index.jsp" ;
    }

    @GetMapping("/getAllRegistrations")
    public String getAllRegister(Model model){
        System.out.println("invoking read all registered user  ");

        List<PhonepayDTO> entity= service.readAllRegister();
        System.out.println("service read registration"+entity);
        model.addAttribute("listOfUsers",entity);

        return "getAllRegistrations.jsp";

    }
    @GetMapping("/id")
    public String getResistrationById(@RequestParam("userid") int id,Model model){
        System.out.println("invoking get registration by id");
        PhonepayDTO dto=service.getRegistrationById(id);
        System.out.println("registration by id"+dto);
        model.addAttribute("userDetails",dto);

        return "registerById.jsp";
    }

    @GetMapping("/editId")
    public String getResDeToForm(@RequestParam("userid")int id,Model model){
        System.out.println("invoking registration id for form");
        PhonepayDTO dto=service.getRegistrationById(id);
        System.out.println("form "+dto);
        model.addAttribute("getform",dto);
        return "updateForm.jsp";
    }

    @PostMapping("/update")
    public String registerUserUpdate( PhonepayDTO userDto,Model model) {


        System.out.println("invoking register user" + userDto);

        String serviceDTO=service.getRegisterUpdate(userDto);
        System.out.println("service dto saved  "+serviceDTO);
        List<PhonepayDTO> entity= service.readAllRegister();

        model.addAttribute("listOfUsers",entity);

        return "getAllRegistrations.jsp";
    }

    @GetMapping("/deleteID/{userId}")
    public String delete(@PathVariable("userId")int id, Model model){
        System.out.println("invoking delete from controller"+id);
        String dto =service.deleteUser(id);
        System.out.println("data"+dto);
        model.addAttribute("delete",dto);
        return "redirect:/getAllRegistrations";
    }

}



