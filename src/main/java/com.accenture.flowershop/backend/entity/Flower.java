package com.accenture.flowershop.entity;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity

@Data
public class Flower implements Serializable {
    private String name;
    private BigDecimal price;
    private int count;

}
