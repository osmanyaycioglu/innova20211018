package com.training.spring.order.models;

import java.util.List;

public class Order {

    private Long       orderNumber;
    private Customer   customer;
    private List<Meal> orederedMeals;

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(final Customer customerParam) {
        this.customer = customerParam;
    }

    public List<Meal> getOrederedMeals() {
        return this.orederedMeals;
    }

    public void setOrederedMeals(final List<Meal> orederedMealsParam) {
        this.orederedMeals = orederedMealsParam;
    }

    public Long getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(final Long orderNumberParam) {
        this.orderNumber = orderNumberParam;
    }


}
