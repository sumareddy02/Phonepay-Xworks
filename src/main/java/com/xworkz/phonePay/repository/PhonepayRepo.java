package com.xworkz.phonePay.repository;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.entity.PhonepayEntity;

public interface PhonepayRepo {
    void savePhonepayRegisterDTO(PhonepayEntity entity);
}
