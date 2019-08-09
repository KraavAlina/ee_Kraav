package com.accenture.flowershop.backend.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

@Data
public class Flower<Int> implements Serializable {
    @Id
    private String name;
    private Double price;
    private Int count;
    private String image;

}
