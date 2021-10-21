package com.training.spring.order.models;


public class OrderResponse {

    private Boolean placed;
    private Long    orderNumber;

    public Boolean getPlaced() {
        return this.placed;
    }

    public void setPlaced(final Boolean placedParam) {
        this.placed = placedParam;
    }

    public Long getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(final Long orderNumberParam) {
        this.orderNumber = orderNumberParam;
    }


}
