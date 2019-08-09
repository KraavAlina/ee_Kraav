package com.accenture.flowershop.backend.entity;
import com.accenture.flowershop.backend.entity.Flower;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Date dateCreation;
    private Date dateClosing;
    private Double fullPrice;
    private List<Flower> flowers;
    private User user;
}