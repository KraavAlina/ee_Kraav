package com.accenture.flowershop.backend.access;

import com.accenture.flowershop.backend.entity.UserEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class UserAccess {

    private Session session;

    @PersistenceContext
    private EntityManager em;

    UserAccess() {

    }

    public void addUser (UserEntity user) {
  /*      Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error session.");
        }

   */
    }

    public UserEntity findUserbyId (int id){return null;}
    public UserEntity findUserbyLogin (String login){return null;}
    public UserEntity findUserbyName (String name){return null;}

    public void changeUser (UserEntity user){}

}
