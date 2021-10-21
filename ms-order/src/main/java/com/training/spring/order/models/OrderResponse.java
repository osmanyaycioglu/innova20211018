package com.training.spring.order.models;


public class OrderResponse {

    private Boolean placed;
    private Long    orderNumber;
    private String  desc;

    public Boolean getPlaced() {
        return this.placed;
    }

    public OrderResponse setPlaced(final Boolean placedParam) {
        this.placed = placedParam;
        return this;
    }

    public Long getOrderNumber() {
        return this.orderNumber;
    }

    public OrderResponse setOrderNumber(final Long orderNumberParam) {
        this.orderNumber = orderNumberParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public OrderResponse setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }


}
