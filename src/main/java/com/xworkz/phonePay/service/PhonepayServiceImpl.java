package com.xworkz.phonePay.service;

import com.xworkz.phonePay.dto.PhonepayDTO;
import org.springframework.stereotype.Service;

@Service

public class PhonepayServiceImpl implements PhonepayService
{
    @Override
    public String savePhonepayRegisterDTO(PhonepayDTO dto) {
        System.out.println("invoking saveRegisterion");

        if(dto != null){
            System.out.println("DTO is not null"+dto);
            return "values is not null";
        }

        return "DTO is null";
    }
}
