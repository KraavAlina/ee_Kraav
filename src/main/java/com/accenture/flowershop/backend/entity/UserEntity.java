package com.accenture.flowershop.backend.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {
    @Id
    private String login;
    private String password;
    private String name;
    private String address;
    private String phone;
    private BigDecimal balance;
    private Integer discount;
    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderEntity> orders = new ArrayList<>();

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public Integer getDiscount() { return discount; }
    public void setDiscount(Integer discount) { this.discount = discount; }

    public List<OrderEntity> getOrders() { return orders; }
    public void setOrders(List<OrderEntity> orders) { this.orders = orders; }

    public void addOrder(OrderEntity d) {
        orders.add(d);
        d.setOwner(this);
    }

    public void removeOrder(OrderEntity d) {
        d.setOwner(null);
        orders.remove(d);
    }

    @Override
    public String toString() {
        return "User (" +
                "login = " + login +
                ", password = " + "*".repeat(password.length()) +
                ", fullName = " + name +
                ", address = " + address +
                ", phone = " + phone +
                ", balance = " + balance +
                ", discount = " + discount +
                ")";
    }
}


