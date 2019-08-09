package com.accenture.flowershop.backend.repository;

import com.accenture.flowershop.backend.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;


public class UserRepository {

    private Session session;

    UserRepository () {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources metadataSources = new MetadataSources(standardRegistry);
        metadataSources.addAnnotatedClass(User.class);
        Metadata metaData = metadataSources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metaData.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public void addUser (User user) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error session.");
        }
    }

    public User findUserbyId (int id){return null;}
    public User findUserbyLogin (String login){return null;}
    public User findUserbyName (String name){return null;}

    public void changeUser (User user){}

}
