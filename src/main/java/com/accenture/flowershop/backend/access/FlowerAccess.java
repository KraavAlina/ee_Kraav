package com.accenture.flowershop.backend.access;


import com.accenture.flowershop.backend.entity.FlowerEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository
public class FlowerAccess {

    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

    @PersistenceContext
    private EntityManager em;

//    private Map<Long, FlowerEntity> mapFlowers;
//    private static Long ID;

    @PostConstruct
    public void init() {
        LOG.info("Flower access on");
//        mapFlowers = new HashMap<>();
//        ID = 0L;
//        FlowerEntity rose = new FlowerEntity("Роза", new BigDecimal("200").setScale(2, RoundingMode.CEILING), 200, "/static/images/rose.jpg");
//        FlowerEntity chamomile = new FlowerEntity("Ромашка", new BigDecimal("100").setScale(2, RoundingMode.CEILING), 300, "/static/images/chamomile.jpg");
//        FlowerEntity georgina = new FlowerEntity("Георгина", new BigDecimal("150").setScale(2, RoundingMode.CEILING), 300, "/static/images/georgina.jpg");
//        FlowerEntity lily = new FlowerEntity("Лилия", new BigDecimal("250").setScale(2, RoundingMode.CEILING), 100, "/static/images/lily.jpg");
//        FlowerEntity peony = new FlowerEntity("Пион", new BigDecimal("150").setScale(2, RoundingMode.CEILING), 300, "/static/images/peony.jpg");
//        ID = ID+1; rose.setId(ID); mapFlowers.put(rose.getId(), rose);
//        ID = ID+1; chamomile.setId(ID); mapFlowers.put(chamomile.getId(), chamomile);
//        ID = ID+1; georgina.setId(ID); mapFlowers.put(georgina.getId(), georgina);
//        ID = ID+1; lily.setId(ID); mapFlowers.put(lily.getId(), lily);
//        ID = ID+1; peony.setId(ID); mapFlowers.put(peony.getId(), peony);
    }

    public FlowerEntity add(FlowerEntity flowerEntity){
//        if (getById(flowerEntity.getId()) != null)
//            return null;
//        ID = ID+1;
//        flowerEntity.setId(ID);
//        mapFlowers.put(flowerEntity.getId(),flowerEntity);
//        return flowerEntity;

        em.persist(flowerEntity);
        em.flush();
        return flowerEntity;
    }


    public FlowerEntity getById(Long id){
//        return mapFlowers.get(id);
        return em.find(FlowerEntity.class, id);
    }

    public List<FlowerEntity> getByName(String name){
        String collectedString = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase();
        TypedQuery<FlowerEntity> flowerQuery = em.createQuery("SELECT f FROM FlowerEntity f WHERE f.name LIKE :name", FlowerEntity.class);
        flowerQuery.setParameter("name", "%" + collectedString + "%");
        return flowerQuery.getResultList();
    }


    public List<FlowerEntity> getByPrice(BigDecimal fromPrice, BigDecimal toPrice){
        TypedQuery<FlowerEntity> flowerQuery;
        if (fromPrice.equals(BigDecimal.ZERO)) {
            flowerQuery = em.createQuery("SELECT f FROM FlowerEntity f WHERE f.price <= :toPrice", FlowerEntity.class);
            flowerQuery.setParameter("toPrice", toPrice);
            return flowerQuery.getResultList();
        }
        if (toPrice.equals(BigDecimal.ZERO)) {
            flowerQuery = em.createQuery("SELECT f FROM FlowerEntity f WHERE f.price >= :fromPrice", FlowerEntity.class);
            flowerQuery.setParameter("fromPrice", fromPrice);
            return flowerQuery.getResultList();
        }
        if (fromPrice.compareTo(BigDecimal.ZERO) > -1  && toPrice.compareTo(BigDecimal.ZERO) > -1) {
            flowerQuery = em.createQuery("SELECT f FROM FlowerEntity f WHERE f.price <= :toPrice AND f.price >= :fromPrice", FlowerEntity.class);
            flowerQuery.setParameter("fromPrice", fromPrice);
            flowerQuery.setParameter("toPrice", toPrice);
            return flowerQuery.getResultList();
        }
        return null;
    }


    public void update(FlowerEntity flowerEntity){
//        if (getById(flowerEntity.getId()) != null)
//            delete(flowerEntity);
//        else {
//            ID = ID + 1;
//            flowerEntity.setId(ID);
//        }
//        mapFlowers.put(flowerEntity.getId(),flowerEntity);

        em.merge(flowerEntity);
        em.flush();
    }

    public List<FlowerEntity> getAll(){
//        return new ArrayList<FlowerEntity>(mapFlowers.values());
        TypedQuery<FlowerEntity> namedQuery = em.createNamedQuery("FlowerEntity.getAll", FlowerEntity.class);
        return namedQuery.getResultList();
    }

}


