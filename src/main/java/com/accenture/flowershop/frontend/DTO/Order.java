package com.accenture.flowershop.frontend.DTO;

import com.accenture.flowershop.backend.entity.enums.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Order implements Serializable {
    private Long id;
    private OrderStatus status;
    private LocalDateTime dateCreation;
    private LocalDateTime dateClosing;
    private BigDecimal fullPrice;
    private User owner;

    public Order() { }

    public Order(BigDecimal fullPrice, User owner) {
        this.fullPrice = fullPrice;
        this.dateCreation = LocalDateTime.now();
        this.dateClosing = null;
        this.status = OrderStatus.CREATED;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFullPrice() {
        return fullPrice;
    }
    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateClosing() {
        return dateClosing;
    }
    public void setDateClosing(LocalDateTime dateClosing) {
        this.dateClosing = dateClosing;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order temp = (Order) o;
        if ( this.id.equals(((Order) o).id) &&
                this.status.equals(((Order) o).status) &&
                this.dateCreation.equals(((Order) o).dateCreation) &&
                this.dateClosing.equals(((Order) o).dateCreation) &&
                this.fullPrice.equals(((Order) o).fullPrice) &&
                this.owner.equals(((Order) o).owner)
        )
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Order(" +
                "id = " + id +
                ", fullPrice = " + fullPrice +
                ", dateCreation = " + dateCreation +
                ", dateClosing = " + dateClosing +
                ", status = " + status +
                ", owner=" + owner.getLogin() +
                ")";
    }
}
