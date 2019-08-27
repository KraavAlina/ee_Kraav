package com.accenture.flowershop.backend.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table(name = "USERS")
@Entity(name = "UserEntity")
public class UserEntity implements Serializable {
    @Id
    private String login;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private BigDecimal balance;
    private Integer discount;

    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity (){}

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserEntity (String login, String password, String fullName, String address, String phone) {
        this.setLogin(login);
        this.setPassword(password);
        this.setFullName(fullName);
        this.setAddress(address);
        this.setPhone(phone);
    }

    public Boolean isAdmin() { return (login.equals("admin")); }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return  Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getFullName(), that.getFullName()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getBalance(), that.getBalance()) &&
                Objects.equals(getDiscount(), that.getDiscount()) &&
                Objects.equals(getOrders(), that.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getFullName(), getAddress(), getPhone(), getBalance(), getDiscount(), getOrders());
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                ", login='" + login + '\'' +
                ", password='" + "*".repeat(password.length()) + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                ", orders=" + orders +
                '}';
    }
}


