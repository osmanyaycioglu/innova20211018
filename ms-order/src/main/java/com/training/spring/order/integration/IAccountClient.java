package com.training.spring.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.spring.order.models.Customer;

@FeignClient(value = "RESTAURANT-CONTEXT", contextId = "customer")
@RequestMapping("/api/v1/customer/query")
public interface IAccountClient {

    @GetMapping("/get/one")
    public Customer getCustomer(@RequestParam("phone") final String number);


}
