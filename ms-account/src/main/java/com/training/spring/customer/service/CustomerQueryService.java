package com.training.spring.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.customer.Customer;
import com.training.spring.customer.data.CustomerStorage;

@Service
public class CustomerQueryService {


    @Autowired
    private CustomerStorage cs;

    public Customer getCustomer(final String customerNumber) {
        return this.cs.get(customerNumber);
    }

}
