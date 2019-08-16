package com.accenture.flowershop.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "FLOWERS")
public class FlowerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cust")
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer countFlowersInStock;
    private String image;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getCount() { return countFlowersInStock; }
    public void setCount(Integer countFlowersInStock) { this.countFlowersInStock = countFlowersInStock; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    @Override
    public String toString() {
        return "Flower (" +
                "name = " + name +
                ", price = " + price +
                ", countFlowersInStock = " + countFlowersInStock +
                ")";
    }
}
