package com.xworkz.phonePay.repository;

import com.xworkz.phonePay.entity.PhonepayEntity;

import java.util.List;

public interface PhonepayRepo {
    String savePhonepayRegisterDTO(PhonepayEntity entity);
    public List<PhonepayEntity> readALlRegister();
    public PhonepayEntity readRegistrationById(int id);
    public String registerMessage();
    public PhonepayEntity updateRegisterById(PhonepayEntity entity );
    public void deleteProductById(int id);
}
