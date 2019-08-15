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
    private Integer count;
    @Column(name = "flower_count")
    private String image;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    @Override
    public String toString() {
        return "Flower (" +
                "name = " + name +
                ", price = " + price +
                ", count = " + count +
                ")";
    }
}
