package com.training.spring.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.models.Customer;

@Service
public class AccountServiceIntegration {

    @Autowired
    private IAccountClient ac;

    public Customer getCustomer(final String number) {
        return this.ac.getCustomer(number);
    }

}
