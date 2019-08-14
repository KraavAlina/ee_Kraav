package com.accenture.flowershop.backend.repository;

import com.accenture.flowershop.backend.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class UserRepository {

    private Session session;

    UserRepository () {

    }

    public void addUser (User user) {
  /*      Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error session.");
        }

   */
    }

    public User findUserbyId (int id){return null;}
    public User findUserbyLogin (String login){return null;}
    public User findUserbyName (String name){return null;}

    public void changeUser (User user){}

}
