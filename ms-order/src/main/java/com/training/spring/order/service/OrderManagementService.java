package com.training.spring.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.error.RestClientException;
import com.training.spring.order.integration.PersonServiceIntegration;
import com.training.spring.order.models.Order;
import com.training.spring.order.models.OrderResponse;

@Service
public class OrderManagementService {

    @Autowired
    private PersonServiceIntegration psi;

    public OrderResponse place(final Order orderParam) throws RestClientException {
        String callHello2Loc = this.psi.callHello2b(orderParam.getCustomer()
                                                              .getName());
        return new OrderResponse().setDesc(callHello2Loc);
    }

}
