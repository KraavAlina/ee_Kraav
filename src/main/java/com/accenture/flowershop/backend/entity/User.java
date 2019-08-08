package com.accenture.flowershop.backend.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

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