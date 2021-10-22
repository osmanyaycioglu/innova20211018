package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue", autoDelete = "false", durable = "true"),
                                             exchange = @Exchange(name = "sms-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "send.sms"))
    public void name(final NotificationMessage message) {
        System.out.println("Received : " + message);
    }

}
