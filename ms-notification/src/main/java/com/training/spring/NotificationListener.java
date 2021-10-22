package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue", autoDelete = "false", durable = "true"),
                                             exchange = @Exchange(name = "sms-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "send.sms"))
    @SendTo("sms-exchange/response.send.sms")
    public String name(final NotificationMessage message) {
        System.out.println("Received : " + message);
        return "SMS send to : " + message.getDestination();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "message-log",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.#"))
    public void handleAllMessages(final NotificationMessage message) {
        System.out.println("Log Received : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-message",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.sms.#"))
    public void handleSMSMessages(final NotificationMessage message) {
        System.out.println("SMS Received : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "mail-message",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.mail.#"))
    public void handleMailMessages(final NotificationMessage message) {
        System.out.println("MAIL Received : " + message);
    }

}
