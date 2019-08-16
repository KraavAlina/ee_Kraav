package com.accenture.flowershop.backend.entity;

import com.accenture.flowershop.frontend.DTO.Flower;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_FLOWERS")
public class OrderFlowersEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "flower")
    private FlowerEntity flower;
    private Integer countFlowersInOrder;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;

    public Long getId() { return id; }

    public FlowerEntity getFlower() { return flower; }
    public void setFlowerName(FlowerEntity flower) { this.flower = flower; }

    public Integer getCount() { return countFlowersInOrder; }
    public void setCount(Integer countFlowersInOrder) { this.countFlowersInOrder = countFlowersInOrder; }

    public OrderEntity getOrder() { return order; }
    public void setOrderId(OrderEntity orderId) { this.order = order; }

    @Override
    public String toString() {
        return "OrderFlower(" +
                "id = " + id +
                ", flowerName = " + flower.getName() +
                ", countFlowersInOrder = " + countFlowersInOrder +
                ", orderId = " + order.getId() +
                ")";
    }
}