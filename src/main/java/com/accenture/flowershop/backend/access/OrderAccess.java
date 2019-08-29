package com.accenture.flowershop.backend.access;


import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.OrderBy;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository
public class OrderAccess {
    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

    @PersistenceContext
    private EntityManager em;

//    private Map<Long, OrderEntity> mapOrder;
//    private static Long IDOrder;

    @PostConstruct
    public void init() {
        LOG.info("Order access on");
//        mapOrder = new HashMap<>();
//        IDOrder = 0L;
    }

    public OrderEntity add(OrderEntity orderEntity){
//        if (get(orderEntity) != null)
//            return null;
//        IDOrder = IDOrder+1;
//        orderEntity.setId(IDOrder);
//        mapOrder.put(orderEntity.getId(),orderEntity);
//        return orderEntity;
        em.persist(orderEntity);
        em.flush();
        return (get(orderEntity));
    }

    public void delete(OrderEntity orderEntity){
//        mapOrder.remove(orderEntity.getId());
        em.remove(get(orderEntity));
    }

    public OrderEntity getById (Long id) {
        return em.find(OrderEntity.class, id);
//        return mapOrder.get(id);
    }

    public OrderEntity get(OrderEntity orderEntity){
//        return mapOrder.get(orderEntity.getId());
        return em.find(OrderEntity.class, orderEntity.getId());
    }

    public void update(OrderEntity orderEntity){
//        if (get(orderEntity) != null)
//            delete(orderEntity);
//        mapOrder.put(orderEntity.getId(), orderEntity);
        em.merge(orderEntity);
        em.flush();
    }

    public List<OrderEntity> getAll(){
//        return new ArrayList<OrderEntity>(mapOrder.values());
        TypedQuery<OrderEntity> namedQuery = em.createNamedQuery("OrderEntity.getAll", OrderEntity.class);
        return namedQuery.getResultList();
    }

    public List<OrderEntity> getAllByOrder(){
        String query = "SELECT o FROM OrderEntity AS o ORDER BY o.dateCreation DESC, o.status DESC";
        return em.createQuery(query).getResultList();
    }



}
