package com.accenture.flowershop.backend.entity;
import com.accenture.flowershop.backend.entity.enums.OrderStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ORDER")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Date dateCreation;
    private Date dateClosing;
    private BigDecimal fullPrice;
    @OneToMany (mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderFlowersEntity> flowers = new ArrayList<OrderFlowersEntity>();;
    @ManyToOne
    @JoinColumn(name = "owner",  referencedColumnName = "login")
    private UserEntity owner;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getFullPrice() { return fullPrice; }
    public void setFullPrice(BigDecimal fullPrice) { this.fullPrice = fullPrice; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Date getDateClosing() { return dateClosing; }
    public void setDateClosing(Date dateClosing) { this.dateClosing = dateClosing; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public UserEntity getOwner() { return owner; }
    public void setOwner(UserEntity owner) { this.owner = owner; }

    public List<OrderFlowersEntity> getFlowers() { return flowers; }
    public void setFlowers(List<OrderFlowersEntity> flowers) { this.flowers = flowers; }

    public void addFlowers(OrderFlowersEntity d) {
        flowers.add(d);
        d.setOrderId(this.id);
    }
    public void removeFlowers(OrderFlowersEntity d) {
        d.setOrderId(null);
        flowers.remove(d);
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