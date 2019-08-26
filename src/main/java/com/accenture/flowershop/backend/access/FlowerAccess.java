package com.accenture.flowershop.backend.access;


import com.accenture.flowershop.backend.entity.FlowerEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class FlowerAccess {

    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

//    @PersistenceContext
//    private EntityManager em;

    private Map<Long, FlowerEntity> mapFlowers;
    private static Long ID;

    @PostConstruct
    public void init() {
        LOG.info("Flower access on");
        mapFlowers = new HashMap<>();
        ID = 0L;
        FlowerEntity rose = new FlowerEntity("Роза", new BigDecimal("200").setScale(2, RoundingMode.CEILING), 200, "/static/images/rose.jpg");
        FlowerEntity chamomile = new FlowerEntity("Ромашка", new BigDecimal("100").setScale(2, RoundingMode.CEILING), 300, "/static/images/chamomile.jpg");
        FlowerEntity georgina = new FlowerEntity("Георгина", new BigDecimal("150").setScale(2, RoundingMode.CEILING), 300, "/static/images/georgina.jpg");
        FlowerEntity lily = new FlowerEntity("Лилия", new BigDecimal("250").setScale(2, RoundingMode.CEILING), 100, "/static/images/lily.jpg");
        FlowerEntity peony = new FlowerEntity("Пион", new BigDecimal("150").setScale(2, RoundingMode.CEILING), 300, "/static/images/peony.jpg");
        ID = ID+1; rose.setId(ID);
        ID = ID+1; chamomile.setId(ID);
        ID = ID+1; georgina.setId(ID);
        ID = ID+1; lily.setId(ID);
        ID = ID+1; peony.setId(ID);
        mapFlowers.put(rose.getId(), rose);
        mapFlowers.put(chamomile.getId(), chamomile);
        mapFlowers.put(georgina.getId(), georgina);
        mapFlowers.put(lily.getId(), lily);
        mapFlowers.put(peony.getId(), peony);
    }

    public FlowerEntity add(FlowerEntity flowerEntity){
        if (getById(flowerEntity.getId()) != null)
            return null;
        ID = ID+1;
        flowerEntity.setId(ID);
        mapFlowers.put(flowerEntity.getId(),flowerEntity);
        return flowerEntity;

//        em.getTransaction().begin();
//        em.persist(flower);
//        em.getTransaction().commit();
    }

    public void delete(FlowerEntity flowerEntity){
        mapFlowers.remove(flowerEntity.getId());
//        em.getTransaction().begin();
//        em.remove(get(id));
//        em.getTransaction().commit();
    }


    public FlowerEntity getById(Long id){
        return mapFlowers.get(id);
//        return em.find(FlowerEntity.class, id);
    }



    public void update(FlowerEntity flowerEntity){
        if (getById(flowerEntity.getId()) != null)
            delete(flowerEntity);
        else {
            ID = ID + 1;
            flowerEntity.setId(ID);
        }
        mapFlowers.put(flowerEntity.getId(),flowerEntity);
//        em.getTransaction().begin();
//        em.persist(flower);
//        em.getTransaction().commit();
    }

    public List<FlowerEntity> getAll(){
        return new ArrayList<FlowerEntity>(mapFlowers.values());
//        TypedQuery<FlowerEntity> namedQuery = em.createNamedQuery("FlowerEntity.getAll", FlowerEntity.class);
//        return namedQuery.getResultList();
    }

}


