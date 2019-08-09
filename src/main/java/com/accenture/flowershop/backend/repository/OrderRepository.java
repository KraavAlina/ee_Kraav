package com.accenture.flowershop.backend.repository;


import com.accenture.flowershop.backend.entity.Order;
import com.accenture.flowershop.backend.entity.User;

import java.util.Date;
import java.util.List;

public class OrderRepository {

    public void addOrder (Order order) {}

    public Order findOrderbyId (int id) {return null;}
    public List<Order> findOrdersbyStatus (String status){return null;}
    public List<Order> findOrdersbyDateCreation (Date dateCreation){return null;}
    public List<Order> findOrdersbyUser (User user){return null;}

    public void changeOrder (Order order){}

    public void removeOrder (Order order){}
}
