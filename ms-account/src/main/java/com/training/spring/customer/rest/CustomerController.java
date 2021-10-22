package com.training.spring.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.customer.Customer;
import com.training.spring.customer.service.CustomerQueryService;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerController {

    @Autowired
    private CustomerQueryService cqs;

    @GetMapping("/get/one")
    public Customer getCustomer(@RequestParam("phone") final String number) {
        return this.cqs.getCustomer(number);
    }

}
