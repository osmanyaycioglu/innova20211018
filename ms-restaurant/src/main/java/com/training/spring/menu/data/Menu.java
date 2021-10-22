package com.training.spring.menu.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class Menu {

    private final Map<String, MenuItem> map = new ConcurrentHashMap<>();


    public Menu() {

        this.map.put("kebap",
                     new MenuItem().setMealName("kebap")
                                   .setMealDescription("Adana kebap")
                                   .setPrice(BigDecimal.valueOf(45L)));
        this.map.put("lahmacun",
                     new MenuItem().setMealName("lahmacun")
                                   .setMealDescription("acısız lahmacun")
                                   .setPrice(BigDecimal.valueOf(15L)));
    }

    public MenuItem getMealInformation(final String mealName) {
        return this.map.get(mealName);
    }

    public List<MenuItem> getAll() {
        return new ArrayList<>(this.map.values());
    }

}
