package com.accenture.flowershop.backend.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FLOWERS")
@Data
public class Flower {
    @Id
    private String name;
    private BigDecimal price;
    private Integer count;
    private String image;

}
