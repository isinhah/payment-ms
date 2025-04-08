package com.spring.backend_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentSuccessProducer {

    private AmqpTemplate amqpTemplate;

    public PaymentSuccessProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void generateResponse(String message) {
        amqpTemplate.convertAndSend(
                "payment-response-success-exchange",
                "payment-response-success-routing-key",
                message
        );
    }
}
