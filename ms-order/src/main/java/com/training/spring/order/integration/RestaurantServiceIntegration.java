package com.training.spring.order.integration;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.models.Meal;

@Service
public class RestaurantServiceIntegration {

    @Autowired
    private IRestaurantMenuClient rmc;

    public BigDecimal getPrice(final List<Meal> listParam) {
        return this.rmc.getPrice(listParam);
    }
}
