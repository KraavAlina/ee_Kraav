package com.accenture.flowershop.frontend.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class Flower implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer count;
    private String image

    public Flower(Long id, String name, BigDecimal price, Integer count, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.image = image;
    }

    public Flower() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public OrderFlowers toOrderData(Integer count) {
        return new OrderFlowers(id, null, );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower temp = (Flower) o;
        if (this.id.equals(((Flower) o).id) &&
                this.name.equals(((Flower) o).name) &&
                this.price.equals(((Flower) o).price) &&
                this.count.equals(((Flower) o).count) &&
                this.image.equals(((Flower) o).image))
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Flower(" +
                "id = " + id +
                ", name = " + name +
                ", price = " + price +
                ", count = " + count +
                ")";
    }
}
