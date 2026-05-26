package com.xworkz.phonePay.repository;

import com.xworkz.phonePay.entity.PhonepayEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class PhonepayRepoImpl implements PhonepayRepo {
    @Override
    public String savePhonepayRegisterDTO(PhonepayEntity entity) {
        System.out.println("invoking saveRegisterion");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        String save = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("something");
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            save = "Registered successfully";
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

        return save;
    }

    @Override
    public PhonepayEntity readRegistrationById(int id) {
        System.out.println("invoking read product method and id is " + id);

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        PhonepayEntity entity = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("something");

            entityManager = entityManagerFactory.createEntityManager();

            entity = entityManager.find(PhonepayEntity.class, id);

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (entityManager != null) {
                entityManager.close();
            }

            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

        return entity;
    }

    @Override
    public List<PhonepayEntity> readALlRegister() {
        System.out.println("invoking read all Register");

        List<PhonepayEntity> entity = Collections.emptyList();

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("something");

            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findAllUsers");
            entity = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (entityManager != null) {
                entityManager.close();
            }

            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
        return entity;
    }

    public String registerMessage() {
        System.out.println("invoking register message");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        String save = null;
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("something");
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            transaction.commit();
            save = "REgistered successfully";

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (entityManager != null) {
                entityManager.close();
            }

            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
        return save;

    }


    @Override
    public PhonepayEntity updateRegisterById(PhonepayEntity entity) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("something");

            entityManager = entityManagerFactory.createEntityManager();

            transaction = entityManager.getTransaction();

            transaction.begin();

            PhonepayEntity newEntity = entityManager.find(PhonepayEntity.class, entity.getId());
            System.out.println("data from service to repo"+newEntity);

            if (newEntity != null) {
                newEntity.setId(entity.getId());
                newEntity.setFname(entity.getFname());
                newEntity.setLname(entity.getLname());
                newEntity.setMobileNumber(entity.getMobileNumber());
                newEntity.setPassword(entity.getPassword());
                newEntity.setEmailID(entity.getEmailID());

                entityManager.merge(newEntity);

                System.out.println("Product Updated");
            } else {
                System.out.println("Product Not Found");
            }

            transaction.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }

            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
        return entity;
    }

    @Override
    public void deleteProductById(int id){

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("something");

            entityManager = entityManagerFactory.createEntityManager();

            transaction = entityManager.getTransaction();

            transaction.begin();


            PhonepayEntity entity = entityManager.find(PhonepayEntity.class, id);

            if (entity != null) {

                // Delete object
                entityManager.remove(entity);

                System.out.println("Data Deleted");

            } else {

                System.out.println("ID Not Found");
            }

            transaction.commit();

        } catch (PersistenceException e) {

            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }

            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

}