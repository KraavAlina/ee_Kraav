package com.accenture.flowershop.backend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_FLOWERS")
public class OrderFlowersEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long flowerId;
    private Integer count;
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName="id")
    private Long orderId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFlowerName() { return flowerId; }
    public void setFlowerName(Long flowerId) { this.flowerId = flowerId; }

    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    @Override
    public String toString() {
        return "OrderFlower (" +
                "id = " + id +
                ", flowerName = " + flowerId +
                ", count = " + count +
                ", order = " + orderId +
                ")";
    }
}