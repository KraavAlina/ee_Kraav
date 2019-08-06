package com.accenture.flowershop.entity;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity

@Data
public class User implements Serializable {
    private String login;
    private String password;
    private String name;
    private String address;
    private String phone;
    private BigDecimal balance;
    private double price;
    private int count;
}