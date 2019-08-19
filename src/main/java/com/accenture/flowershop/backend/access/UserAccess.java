package com.accenture.flowershop.backend.access;

import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserAccess {

    @PersistenceContext
    public EntityManager em;

    public void add(UserEntity user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
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
        em.persist(user);
        em.getTransaction().commit();
    }

    public List<UserEntity> getAll(){
        TypedQuery<UserEntity> namedQuery = em.createNamedQuery("OrderEntity.getAll", UserEntity.class);
        return namedQuery.getResultList();
    }
}
