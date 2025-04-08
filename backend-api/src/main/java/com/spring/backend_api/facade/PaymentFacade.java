package com.spring.backend_api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.backend_api.dto.PaymentDto;
import com.spring.backend_api.producer.PaymentRequestProducer;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    private PaymentRequestProducer producer;

    public PaymentFacade(PaymentRequestProducer producer) {
        this.producer = producer;
    }

    public String requestPayment(PaymentDto request) {
        try {
            producer.integrate(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao solicitar o pagamento..." + e.getMessage();
        }
        return "Pagamento aguardando confirmação";
    }

    public void errorPayment(String payload) {
        System.err.println("ERROR RESPONSE: " + payload);
    }

    public void successPayment(String payload) {
        System.err.println("SUCCESS RESPONSE: " + payload);
    }
}