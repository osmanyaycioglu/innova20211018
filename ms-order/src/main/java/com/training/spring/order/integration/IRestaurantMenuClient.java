package com.training.spring.order.integration;

import java.awt.MenuItem;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.spring.order.models.Meal;

@FeignClient(value = "RESTAURANT-CONTEXT", contextId = "restaurant")
@RequestMapping("/api/v1/restaurant/menu")
public interface IRestaurantMenuClient {

    @PostMapping("/calculate/price")
    public BigDecimal getPrice(final List<Meal> listParam);

    @GetMapping("/get/all")
    public List<MenuItem> getAll();
}
