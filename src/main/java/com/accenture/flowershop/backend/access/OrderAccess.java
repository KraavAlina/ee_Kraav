package com.accenture.flowershop.backend.access;


import com.accenture.flowershop.backend.entity.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderAccess {

    @PersistenceContext
    public EntityManager em;

    public OrderEntity add(OrderEntity order){
        em.getTransaction().begin();
        OrderEntity orderFromDB = em.merge(order);
        em.getTransaction().commit();
        return orderFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public OrderEntity get(long id){
        return em.find(OrderEntity.class, id);
    }

    public void update(OrderEntity order){
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    public List<OrderEntity> getAll(){
        TypedQuery<OrderEntity> namedQuery = em.createNamedQuery("OrderEntity.getAll", OrderEntity.class);
        return namedQuery.getResultList();
    }
}
