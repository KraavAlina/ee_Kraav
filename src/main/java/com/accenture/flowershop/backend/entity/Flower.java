package com.accenture.flowershop.backend.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FLOWERS")
@Data
public class Flower {
    @Id
    private String name;
    private Double price;
    private int count;
    private String image;

}
