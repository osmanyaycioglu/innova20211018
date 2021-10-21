package com.training.spring.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.order.models.Order;
import com.training.spring.order.models.OrderResponse;
import com.training.spring.order.service.OrderManagementService;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @Autowired
    private OrderManagementService oms;

    @PostMapping("/place")
    public OrderResponse place(@RequestBody final Order orderParam) {
        return this.oms.place(orderParam);
    }


}
