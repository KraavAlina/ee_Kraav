package com.accenture.flowershop.backend.services;

import com.accenture.flowershop.backend.access.UserAccess;
import com.accenture.flowershop.backend.entity.UserEntity;
import com.accenture.flowershop.frontend.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

@Transactional
@Service
public class UserService  {
    private static final Logger LOG = Logger.getLogger(UserEntity.class.getName());

    @Autowired
    private XMLConverter converter;

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

        User user = new User(userEntity.getLogin(),userEntity.getPassword(),userEntity.getFullName(),userEntity.getAddress(),userEntity.getPhone());
        createXML(user);

        return savedUser;
    }

    public UserEntity login (UserEntity userEntity){
        return userAccess.get(userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        userAccess.update(userEntity);
    }

    public void createXML(User user) {
        try {
            String filepath =  converter.getPath() + "user_" + user.getLogin() + ".xml";
            converter.convertFromObjectToXML(user, filepath);
        } catch (IOException e) {
            LOG.info("Failed to convert to xml");
        }
    }

}
