package com.accenture.flowershop.backend.entity;
import com.accenture.flowershop.backend.enums.OrderStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ORDER")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime dateCreation;
    private LocalDateTime dateClosing;
    private BigDecimal fullPrice;
    @ManyToOne
    @JoinColumn(name = "owner",  referencedColumnName = "login")
    private UserEntity owner;
    @OneToMany (mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderFlowersEntity> flowersDate = new ArrayList<OrderFlowersEntity>();;

    public Long getId() { return id; }

    public BigDecimal getFullPrice() { return fullPrice; }
    public void setFullPrice(BigDecimal fullPrice) { this.fullPrice = fullPrice; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public LocalDateTime getDateClosing() { return dateClosing; }
    public void setDateClosing(LocalDateTime dateClosing) { this.dateClosing = dateClosing; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public UserEntity getOwner() { return owner; }
    public void setOwner(UserEntity owner) { this.owner = owner; }

    public List<OrderFlowersEntity> getFlowersDate() { return flowersDate; }
    public void setFlowersDate(List<OrderFlowersEntity> flowersDate) { this.flowersDate = flowersDate; }

    public void addFlowers(OrderFlowersEntity d) {
        flowersDate.add(d);
        d.setOrderId(this);
    }
    public void removeFlowers(OrderFlowersEntity d) {
        d.setOrderId(null);
        flowersDate.remove(d);
    }

    @Override
    public String toString() {
        return "OrderEntity (" +
                "id = " + id +
                ", fullPrice = " + fullPrice +
                ", dateCreation = " + dateCreation +
                ", dateClosing = " + dateClosing +
                ", status = " + status +
                ", owner = " + owner +
                ")";
    }
}