package com.accenture.flowershop.backend.access;


import com.accenture.flowershop.backend.entity.FlowersInOrderEntity;
import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class OrderAccess {
    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

//    @PersistenceContext
//    private EntityManager em;

    private Map<Long, OrderEntity> mapOrder;
    private Map<Long, FlowersInOrderEntity> flowersInOrderEntityMap;

    private static Long IDOrder;

    @PostConstruct
    public void init() {
        LOG.info("Order access on");
        mapOrder = new HashMap<>();
        IDOrder = 0L;
    }

    public OrderEntity add(OrderEntity orderEntity){
        if (get(orderEntity) != null)
            return null;
        IDOrder = IDOrder+1;
        orderEntity.setId(IDOrder);
        mapOrder.put(orderEntity.getId(),orderEntity);
        return orderEntity;
//        em.getTransaction().begin();
//        OrderEntity orderFromDB = em.merge(order);
//        em.getTransaction().commit();
//        return orderFromDB;
    }

    public void delete(OrderEntity orderEntity){
        mapOrder.remove(orderEntity.getId());
//        em.getTransaction().begin();
//        em.remove(get(id));
//        em.getTransaction().commit();
    }

    public OrderEntity getById (Long id) {
        return mapOrder.get(id);
    }

    public OrderEntity get(OrderEntity orderEntity){
        return mapOrder.get(orderEntity.getId());
//        return em.find(OrderEntity.class, id);
    }

    public void update(OrderEntity orderEntity){
        if (get(orderEntity) != null)
            delete(orderEntity);
        mapOrder.put(orderEntity.getId(), orderEntity);
//        em.getTransaction().begin();
//        em.merge(order);
//        em.getTransaction().commit();
    }

    public List<OrderEntity> getAll(){
        return new ArrayList<OrderEntity>(mapOrder.values());
//        TypedQuery<OrderEntity> namedQuery = em.createNamedQuery("OrderEntity.getAll", OrderEntity.class);
//        return namedQuery.getResultList();
    }
}
