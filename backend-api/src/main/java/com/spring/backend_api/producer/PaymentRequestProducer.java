package com.spring.backend_api.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.backend_api.dto.PaymentDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestProducer {

    private AmqpTemplate amqpTemplate;

    public PaymentRequestProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrate(PaymentDto payment) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "payment-request-exchange",
                "payment-request-routing-key",
                objectMapper.writeValueAsString(payment)
        );
    }
}