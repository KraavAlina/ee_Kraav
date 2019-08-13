package com.accenture.flowershop.backend.repository;

import com.accenture.flowershop.backend.entity.Flower;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class FlowerRepository {

    private Session session;

    public FlowerRepository() {
        StandardServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources metadataSources = new MetadataSources(standardRegistry);
        metadataSources.addAnnotatedClass(Flower.class);
        Metadata metaData = metadataSources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metaData.buildSessionFactory();
        session = sessionFactory.openSession();

    }

    public void addFlower(Flower flower) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(flower);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Flower findFlowerbyName(String name) {
        return null;
    }

    public void changeFlower(Flower flower) {
    }

    public void removeFlower(Flower flower) {
    }
}
