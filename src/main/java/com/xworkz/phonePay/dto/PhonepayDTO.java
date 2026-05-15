package com.xworkz.phonePay.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

//@Setter
//@Getter
@Data
@Component
public class PhonepayDTO {

    private String fname;
    private String lname;
    private String mobileNumber;
    private String emailID;
    private String Password;


}
