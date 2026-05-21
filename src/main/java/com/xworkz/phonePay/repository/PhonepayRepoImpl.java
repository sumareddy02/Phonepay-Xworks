package com.xworkz.phonePay.repository;

import com.xworkz.phonePay.dto.PhonepayDTO;
import com.xworkz.phonePay.entity.PhonepayEntity;

import javax.persistence.*;

public class PhonepayRepoImpl implements PhonepayRepo {
    @Override
    public void savePhonepayRegisterDTO(PhonepayEntity entity) {
        System.out.println("invoking saveRegisterion");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("something");
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            System.out.println("data is saved");
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (entityManagerFactory != null) {
//            System.out.println("entity manager factor is not null");
                entityManagerFactory.close();
            }
            if (entityManager != null) {
//            System.out.println("entity manager  is not null");
                entityManager.close();
            }

        }

    }
}
