package com.xworkz.phonePay.service;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.entity.PhonepayEntity;
import com.xworkz.phonePay.repository.PhonepayRepo;
import com.xworkz.phonePay.repository.PhonepayRepoImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class PhonepayServiceImpl implements PhonepayService
{
    @Override
    public String savePhonepayRegisterDTO(PhonepayDTO dto) {
        System.out.println("invoking saveRegisterion");
        PhonepayEntity entity=new PhonepayEntity();
        String saved=null;
        entity.setFname(dto.getFname());
        entity.setLname(dto.getLname());
        entity.setPassword(dto.getPassword());
        entity.setEmailID(dto.getEmailID());
        entity.setMobileNumber(dto.getMobileNumber());

        PhonepayRepo repo=new PhonepayRepoImpl();
        saved=repo.savePhonepayRegisterDTO(entity);

        return  saved;

    }

    @Override
    public List<PhonepayDTO> readAllRegister(){
        System.out.println("invoking readRegistration");

        PhonepayRepo repo=new PhonepayRepoImpl();
        List<PhonepayEntity> entityList = repo.readALlRegister();

        List<PhonepayDTO> entity = new ArrayList<>();

        for (PhonepayEntity entities : entityList) {

            PhonepayDTO dto = new PhonepayDTO();

            dto.setId(entities.getId());
            dto.setFname(entities.getFname());
            dto.setLname(entities.getLname());
            dto.setMobileNumber(entities.getMobileNumber());
            dto.setEmailID(entities.getEmailID());
            dto.setPassword(entities.getPassword());

            entity.add(dto);
        }


        return entity;
    }
    @Override
    public PhonepayDTO getRegistrationById(int id){
        System.out.println("invoking service get registration by id");
        PhonepayRepo repo=new PhonepayRepoImpl();
        PhonepayEntity entity=repo.readRegistrationById(id);
        PhonepayDTO dto = new PhonepayDTO();
        dto.setId(entity.getId());
        dto.setFname(entity.getFname());
        dto.setLname(entity.getLname());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setEmailID(entity.getEmailID());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    public String getRegisterUpdate(PhonepayDTO dto){
        System.out.println("invoking service update method" +dto);
        PhonepayEntity entity=new PhonepayEntity();
        String saved=null;
        entity.setId(dto.getId());
        entity.setFname(dto.getFname());
        entity.setLname(dto.getLname());
        entity.setEmailID(dto.getEmailID());
        entity.setMobileNumber(dto.getMobileNumber());
        System.out.println("in service dto to entity values changed"+entity);
        PhonepayRepo repo=new PhonepayRepoImpl();
        repo.updateRegisterById(entity);

        return "successfully updated in service";

    }

    @Override
    public String deleteUser(int id) {
        System.out.println("invoking service delete");
        PhonepayRepo repo=new PhonepayRepoImpl();
        repo.deleteProductById(id);
        return "Deleted from service";
    }
}
