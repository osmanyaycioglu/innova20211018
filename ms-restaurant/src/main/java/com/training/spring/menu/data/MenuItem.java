package com.training.spring.menu.data;

import java.math.BigDecimal;

public class MenuItem {

    private String     mealName;
    private String     mealDescription;
    private BigDecimal price;

    public String getMealName() {
        return this.mealName;
    }

    public MenuItem setMealName(final String mealNameParam) {
        this.mealName = mealNameParam;
        return this;
    }

    public String getMealDescription() {
        return this.mealDescription;
    }

    public MenuItem setMealDescription(final String mealDescriptionParam) {
        this.mealDescription = mealDescriptionParam;
        return this;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public MenuItem setPrice(final BigDecimal priceParam) {
        this.price = priceParam;
        return this;
    }


}
