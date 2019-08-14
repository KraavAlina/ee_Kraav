package com.accenture.flowershop.backend.entity;
import com.accenture.flowershop.backend.entity.Flower;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ORDER")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Date dateCreation;
    private Date dateClosing;
    private BigDecimal fullPrice;
    private List<Flower> flowers;
    private User user;
}