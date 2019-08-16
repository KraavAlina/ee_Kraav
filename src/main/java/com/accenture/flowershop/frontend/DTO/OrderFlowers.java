package com.accenture.flowershop.frontend.DTO;

import java.io.Serializable;

public class OrderFlowers implements Serializable {
    private Long id;
    private Long flowerId;
    private Integer countFlowersInOrder;
    private Long orderId;

    public OrderFlowers() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFlowerId() { return flowerId; }
    public void setFlowerId(Long flowerId) { this.flowerId = flowerId;}

    public Integer getCount() { return countFlowersInOrder; }
    public void setCount(Integer countFlowersInOrder) { this.countFlowersInOrder = countFlowersInOrder; }

    public Long getOrder() { return orderId; }
    public void setOrder(Long orderId) { this.orderId = orderId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderFlowers temp = (OrderFlowers) o;
        if ( this.id.equals(((OrderFlowers) o).id) &&
                this.flowerId.equals(((OrderFlowers) o).flowerId) &&
                this.countFlowersInOrder.equals(((OrderFlowers) o).countFlowersInOrder) &&
                this.orderId.equals(((OrderFlowers) o).orderId)
        )
        return true;
        else return false;
    }


    @Override
    public String toString() {
        return "OrderFlowerData(" +
                "id = " + id +
                ", flowerId = " + flowerId +
                ", countFlowersInOrder = " + countFlowersInOrder +
                ", orderId = " + orderId +
                ")";
    }
}
