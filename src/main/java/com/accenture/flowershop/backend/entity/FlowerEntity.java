package com.accenture.flowershop.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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

    public FlowerEntity(){}

    public FlowerEntity(String name, BigDecimal price, Integer countFlowersInStock, String image) {
        this.name = name;
        this.price = price;
        this.countFlowersInStock = countFlowersInStock;
        this.image = image;
    }
    public void setId(Long id) {this.id = id;} //Todo delete
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowerEntity)) return false;
        FlowerEntity that = (FlowerEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(countFlowersInStock, that.countFlowersInStock) &&
                Objects.equals(getImage(), that.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), countFlowersInStock, getImage());
    }

    @Override
    public String toString() {
        return "FlowerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", countFlowersInStock=" + countFlowersInStock +
                ", image='" + image + '\'' +
                '}';
    }
}
