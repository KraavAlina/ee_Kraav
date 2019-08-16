package com.accenture.flowershop.backend.access;

import com.accenture.flowershop.backend.entity.UserEntity;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class UserAccess {

    @PersistenceContext
    public EntityManager em;

    public UserEntity add(UserEntity user){
        em.getTransaction().begin();
        UserEntity userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public UserEntity get(long id){
        return em.find(UserEntity.class, id);
    }

    public void update(UserEntity user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public List<UserEntity> getAll(){
        TypedQuery<UserEntity> namedQuery = em.createNamedQuery("OrderEntity.getAll", UserEntity.class);
        return namedQuery.getResultList();
    }
}
