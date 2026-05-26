package com.xworkz.phonePay.service;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.entity.PhonepayEntity;

import java.util.List;

public interface PhonepayService {
    String savePhonepayRegisterDTO(PhonepayDTO dto);
    public List<PhonepayDTO> readAllRegister();
    public PhonepayDTO getRegistrationById(int id);
    public String getRegisterUpdate(PhonepayDTO dto);
    public String deleteUser(int id);
}
