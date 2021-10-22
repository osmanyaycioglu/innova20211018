package com.training.spring.order.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.error.RestClientException;
import com.training.spring.order.integration.AccountServiceIntegration;
import com.training.spring.order.integration.PersonServiceIntegration;
import com.training.spring.order.integration.RestaurantServiceIntegration;
import com.training.spring.order.models.Customer;
import com.training.spring.order.models.NotificationMessage;
import com.training.spring.order.models.Order;
import com.training.spring.order.models.OrderResponse;

@Service
public class OrderManagementService {

    private final Map<Long, Order>       orders      = new ConcurrentHashMap<>();
    private final AtomicLong             orderNumber = new AtomicLong(0);

    @Autowired
    private PersonServiceIntegration     psi;

    @Autowired
    private RestaurantServiceIntegration rsi;

    @Autowired
    private AccountServiceIntegration    asi;

    @Autowired
    private RabbitTemplate               rabbitTemplate;

    public OrderResponse place(final Order orderParam) throws RestClientException {
        if (this.orders.size() > 10) {
            return new OrderResponse().setDesc("Şu anda servisimiz dolu")
                                      .setPlaced(false);
        }
        long orderNumberLoc = this.orderNumber.incrementAndGet();
        BigDecimal priceLoc = this.rsi.getPrice(orderParam.getOrederedMeals());
        Customer customerLoc = this.asi.getCustomer(orderParam.getCustomer()
                                                              .getPhone());
        //Customer customerLoc = null;
        String desc = "Yeni müşterimiz sizinle çalışmak güzel. Yeeğiniz hazırlanınca gönderilecek.";
        if (customerLoc != null) {
            desc = "Sayın " + customerLoc.getName() + " " + customerLoc.getSurname() + " iparişiniz hazırlanıyor.";
        }
        NotificationMessage nm = new NotificationMessage();
        nm.setDestination(orderParam.getCustomer()
                                    .getPhone());
        nm.setMessage(desc);
        this.rabbitTemplate.convertAndSend("sms-exchange",
                                           "send.sms",
                                           nm);
        return new OrderResponse().setPrice(priceLoc)
                                  .setPlaced(true)
                                  .setOrderNumber(orderNumberLoc)
                                  .setDesc(desc);
    }

}
