package com.accenture.flowershop.backend.entity;
import com.accenture.flowershop.backend.enums.OrderStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    private BigDecimal discountPrice;
    @ManyToOne
    @JoinColumn(name = "owner",  referencedColumnName = "login")
    private UserEntity owner;
    @OneToMany (mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<FlowersInOrderEntity> flowersDate = new ArrayList<FlowersInOrderEntity>();;

    public OrderEntity(){}

    public OrderEntity(UserEntity owner) {
        this.dateCreation = LocalDateTime.now();
        this.owner = owner;
    }

    public void setId(Long id) {this.id = id;} //Todo delete
    public Long getId() { return id; }

    public BigDecimal getFullPrice() { return fullPrice; }
    public void setFullPrice(BigDecimal fullPrice) { this.fullPrice = fullPrice; }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public LocalDateTime getDateClosing() { return dateClosing; }
    public void setDateClosing(LocalDateTime dateClosing) { this.dateClosing = dateClosing; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public UserEntity getOwner() { return owner; }
    public void setOwner(UserEntity owner) { this.owner = owner; }

    public List<FlowersInOrderEntity> getFlowersDate() { return flowersDate; }
    public void setFlowersDate(List<FlowersInOrderEntity> flowersDate) { this.flowersDate = flowersDate; }

    public void addFlowers(FlowersInOrderEntity d) {
        flowersDate.add(d);
        d.setOrder(this);
    }
    public void removeFlowers(FlowersInOrderEntity d) {
        d.setOrder(null);
        flowersDate.remove(d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderEntity)) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getDateCreation(), that.getDateCreation()) &&
                Objects.equals(getDateClosing(), that.getDateClosing()) &&
                Objects.equals(getFullPrice(), that.getFullPrice()) &&
                Objects.equals(getOwner(), that.getOwner()) &&
                Objects.equals(getFlowersDate(), that.getFlowersDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getDateCreation(), getDateClosing(), getFullPrice(), getOwner(), getFlowersDate());
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", status=" + status +
                ", dateCreation=" + dateCreation +
                ", dateClosing=" + dateClosing +
                ", fullPrice=" + fullPrice +
                ", owner=" + owner.getLogin() +
                ", flowersDateSize=" + flowersDate.size() +
                '}';
    }
}