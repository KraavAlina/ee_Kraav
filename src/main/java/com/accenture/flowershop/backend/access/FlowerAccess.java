package com.accenture.flowershop.backend.access;

import com.accenture.flowershop.backend.entity.FlowerEntity;
import org.hibernate.Session;


public class FlowerAccess {

    private Session session;

    public FlowerAccess() {


    }

    public void addFlower(FlowerEntity flower) {
     /*   Transaction transaction = session.beginTransaction();
        try {
            session.save(flower);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

      */
    }

    public FlowerEntity findFlowerbyName(String name) {
        return null;
    }

    public void changeFlower(FlowerEntity flower) {
    }

    public void removeFlower(FlowerEntity flower) {
    }
}


