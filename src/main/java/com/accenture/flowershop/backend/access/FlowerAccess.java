package com.accenture.flowershop.backend.access;

import com.accenture.flowershop.backend.entity.FlowerEntity;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class FlowerAccess {

    @PersistenceContext
    public EntityManager em;

    public void add(FlowerEntity flower){
        em.getTransaction().begin();
        em.persist(flower);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public FlowerEntity get(long id){
        return em.find(FlowerEntity.class, id);
    }

    public void update(FlowerEntity flower){
        em.getTransaction().begin();
        em.persist(flower);
        em.getTransaction().commit();
    }

    public List<FlowerEntity> getAll(){
        TypedQuery<FlowerEntity> namedQuery = em.createNamedQuery("FlowerEntity.getAll", FlowerEntity.class);
        return namedQuery.getResultList();
    }

}


