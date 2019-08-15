package com.accenture.flowershop.backend.access;


import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.entity.UserEntity;

import java.util.Date;
import java.util.List;

public class OrderAccess {

    public void addOrder (OrderEntity order) {}

    public OrderEntity findOrderById (int id) {return null;}
    public List<OrderEntity> findOrdersByStatus (String status){return null;}
    public List<OrderEntity> findOrdersByDateCreation (Date dateCreation){return null;}
    public List<OrderEntity> findOrdersByUser (UserEntity user){

        return null;}

    public void changeOrder (OrderEntity order){}

    public void removeOrder (OrderEntity order){}
}
