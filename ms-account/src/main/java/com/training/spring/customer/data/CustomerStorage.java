package com.training.spring.customer.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.training.spring.customer.Customer;

@Service
public class CustomerStorage {

    private final Map<String, Customer> customerMap = new ConcurrentHashMap<>();


    public CustomerStorage() {
        this.add(new Customer().setPhone("5435020001")
                               .setName("osman")
                               .setSurname("yaycıoğlu")
                               .setAddress("kadıköy"));
        this.add(new Customer().setPhone("5435020002")
                               .setName("ali")
                               .setSurname("alas")
                               .setAddress("bakırköy"));
    }

    public void add(final Customer customerParam) {
        this.customerMap.put(customerParam.getPhone(),
                             customerParam);
    }

    public Customer get(final String customerNumber) {
        return this.customerMap.get(customerNumber);
    }

}
