package com.accenture.flowershop.backend.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "FLOWERS_IN_ORDER")
public class FlowersInOrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "flowerInOrder")
    private FlowerEntity flower;
    private Integer countFlowersInOrder;
    private BigDecimal pricePerFlower;
    @ManyToOne
    @JoinColumn(name = "orderWithFlowers")
    private OrderEntity order;

    public FlowersInOrderEntity(){}

    public FlowersInOrderEntity(FlowerEntity flower, Integer countFlowersInOrder) {
        this.flower = flower;
        this.countFlowersInOrder = countFlowersInOrder;
        int count = countFlowersInOrder;
        BigDecimal price = flower.getPrice().multiply(new BigDecimal(count));
        this.pricePerFlower = price;
    }

    public void setId(Long id) {this.id = id;} //Todo delete
    public Long getId() { return id; }

    public FlowerEntity getFlower() { return flower; }
    public void setFlowerName(FlowerEntity flower) { this.flower = flower; }

    public Integer getCount() { return countFlowersInOrder; }
    public void setCount(Integer countFlowersInOrder) { this.countFlowersInOrder = countFlowersInOrder; }

    public BigDecimal getPricePerFlower() {
        return pricePerFlower;
    }
    public void setPricePerFlower(BigDecimal pricePerFlower) {
        this.pricePerFlower = pricePerFlower;
    }

    public OrderEntity getOrder() { return order; }
    public void setOrder(OrderEntity order) { this.order = order; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowersInOrderEntity)) return false;
        FlowersInOrderEntity that = (FlowersInOrderEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFlower(), that.getFlower()) &&
                Objects.equals(countFlowersInOrder, that.countFlowersInOrder) &&
                Objects.equals(getOrder(), that.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFlower(), countFlowersInOrder, getOrder());
    }

    @Override
    public String toString() {
        return "FlowersInOrderEntity{" +
                "id=" + id +
                ", flower=" + flower.getName() +
                ", countFlowersInOrder=" + countFlowersInOrder +
                ", order=" + order +
                '}';
    }
}