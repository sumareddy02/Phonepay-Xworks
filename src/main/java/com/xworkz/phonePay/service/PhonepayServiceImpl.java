package com.xworkz.phonePay.service;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.entity.PhonepayEntity;
import com.xworkz.phonePay.repository.PhonepayRepo;
import com.xworkz.phonePay.repository.PhonepayRepoImpl;
import org.springframework.stereotype.Service;

@Service

public class PhonepayServiceImpl implements PhonepayService
{
    @Override
    public String savePhonepayRegisterDTO(PhonepayDTO dto) {
        System.out.println("invoking saveRegisterion");
        PhonepayEntity entity=new PhonepayEntity();

        entity.setFname(dto.getFname());
        entity.setLname(dto.getLname());
        entity.setPassword(dto.getPassword());
        entity.setEmailID(dto.getEmailID());
        entity.setMobileNumber(dto.getMobileNumber());

        PhonepayRepo repo=new PhonepayRepoImpl();
        repo.savePhonepayRegisterDTO(entity);

        return "successfully saved";
    }
}
