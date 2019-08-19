package com.accenture.flowershop.backend.services;

import com.accenture.flowershop.backend.access.UserAccess;
import com.accenture.flowershop.backend.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService  {

    private UserAccess userAccess = new UserAccess();

    public UserService() {
    }

    public UserEntity findUser(int id) {
        return userAccess.get(id);
    }

    public void createUser(UserEntity user) {
        userAccess.add(user);
    }

    public void deleteUser(UserEntity user) {
        userAccess.delete(user.getId());
    }

    public void updateUser(UserEntity user) {
        userAccess.update(user);
    }

    public List<UserEntity> getAllUsers() {
        return userAccess.getAll();
    }

}
