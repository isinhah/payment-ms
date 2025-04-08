package com.spring.backend_worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentErrorProducer {

    private AmqpTemplate amqpTemplate;

    public PaymentErrorProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void generateResponse(String message) {
        amqpTemplate.convertAndSend(
                "payment-response-error-exchange",
                "payment-response-error-routing-key",
                message
        );
    }
}
