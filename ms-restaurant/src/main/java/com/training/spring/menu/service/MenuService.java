package com.training.spring.menu.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.menu.data.Meal;
import com.training.spring.menu.data.Menu;
import com.training.spring.menu.data.MenuItem;

@Service
public class MenuService {

    @Autowired
    private Menu menu;

    public BigDecimal calculatePrice(final List<Meal> listParam) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (Meal mealLoc : listParam) {
            MenuItem mealInformationLoc = this.menu.getMealInformation(mealLoc.getName());
            bigDecimal.add(mealInformationLoc.getPrice()
                                             .multiply(mealLoc.getAmount()));
        }
        return bigDecimal;
    }

    public List<MenuItem> getAll() {
        return this.menu.getAll();
    }


}
