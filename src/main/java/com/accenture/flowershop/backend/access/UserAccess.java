package com.accenture.flowershop.backend.access;

import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Transactional
@Repository
public class UserAccess {
    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

    @PersistenceContext
    private EntityManager em;

    private Map<String, UserEntity> mapUser;


    @PostConstruct
    public void init() {
        LOG.info("User access on");
//        mapUser = new HashMap<>();
//        UserEntity admin = new UserEntity("admin", "admin123", "admin", "unknown", "+0(000)000-0000");
//        UserEntity alina =  new UserEntity("alina","123","Алина", "г. Тверь, ул. Можайского, д.53, кв.5", "+7(980)641-1970");
//        alina.setBalance(new BigDecimal("2000.35").setScale(2, RoundingMode.CEILING));
//        alina.setDiscount(5);
//        mapUser.put("admin", admin);
//        mapUser.put("alina", alina);
    }


    public UserEntity add(UserEntity userEntity){
        em.persist(userEntity);
        return (get(userEntity));
//        if (get(userEntity) != null)
//            return null;
//        ID = ID+1;
//        userEntity.setId(ID);
//        mapUser.put(userEntity.getLogin(),userEntity);
//        return get(userEntity);
    }

    public void delete(UserEntity userEntity){
        mapUser.remove(userEntity.getLogin());
//        em.getTransaction().begin();
//        em.remove(get(id));
//        em.getTransaction().commit();
    }

    public UserEntity get(UserEntity userEntity){
//        return mapUser.get(userEntity.getLogin());
        return em.find(UserEntity.class, userEntity.getLogin());
    }

    public void update(UserEntity userEntity){
        if (get(userEntity) != null)
            delete(userEntity);
        mapUser.put(userEntity.getLogin(), userEntity);
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
    }

    public List<UserEntity> getAll(){
        return new ArrayList<UserEntity>(mapUser.values());
//        TypedQuery<UserEntity> namedQuery = em.createNamedQuery("UserEntity.getAll", UserEntity.class);
//        return namedQuery.getResultList();
    }
}
