package com.training.spring.order.models;

import java.math.BigDecimal;

public class OrderResponse {

    private Boolean    placed;
    private Long       orderNumber;
    private String     desc;
    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return this.price;
    }

    public OrderResponse setPrice(final BigDecimal priceParam) {
        this.price = priceParam;
        return this;
    }


}
