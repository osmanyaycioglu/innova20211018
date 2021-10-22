package com.training.spring.menu.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.menu.data.Meal;
import com.training.spring.menu.data.MenuItem;
import com.training.spring.menu.service.MenuService;

@RestController
@RequestMapping("/api/v1/restaurant/menu")
public class RestaurantMenuController {

    @Autowired
    private MenuService ms;

    @PostMapping("/calculate/price")
    public BigDecimal getPrice(@RequestBody final List<Meal> listParam) {
        return this.ms.calculatePrice(listParam);
    }

    @GetMapping("/get/all")
    public List<MenuItem> getAll() {
        return this.ms.getAll();
    }

}
