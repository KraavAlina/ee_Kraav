package com.accenture.flowershop.backend.services;

import com.accenture.flowershop.backend.access.UserAccess;
import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Service
public class UserService  {
    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

    @Autowired
    private UserAccess userAccess;

    @PostConstruct
    public void init() {
        LOG.info("User service on");
    }

    public UserEntity registration (UserEntity userEntity) {
        if (userAccess.get(userEntity) != null)
            return null;
        userEntity.setBalance(new BigDecimal(2000).setScale(2, RoundingMode.CEILING));
        userEntity.setDiscount(0);
        UserEntity savedUser = userAccess.add(userEntity);
        return savedUser;
    }

    public UserEntity login (UserEntity userEntity){
        return userAccess.get(userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        userAccess.update(userEntity);
    }

}
