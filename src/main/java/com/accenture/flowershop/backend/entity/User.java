package com.accenture.flowershop.backend.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    private Double balance;
    private Double discount;
}