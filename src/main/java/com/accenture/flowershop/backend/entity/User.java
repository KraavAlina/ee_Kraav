package com.accenture.flowershop.backend.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "USER")
@Data
public class User implements Serializable {
    @Id
    private String login;
    private String password;
    private String name;
    private String address;
    private String phone;
    private BigDecimal balance;
    private Double discount;
}