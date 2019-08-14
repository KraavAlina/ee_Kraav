package com.accenture.flowershop.backend.repository;

import com.accenture.flowershop.backend.entity.Flower;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FlowerRepository {

    private Session session;

    public FlowerRepository() {


    }

    public void addFlower(Flower flower) {
     /*   Transaction transaction = session.beginTransaction();
        try {
            session.save(flower);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

      */
    }

    public Flower findFlowerbyName(String name) {
        return null;
    }

    public void changeFlower(Flower flower) {
    }

    public void removeFlower(Flower flower) {
    }
}
