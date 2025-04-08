package com.spring.backend_api.consumer;

import com.spring.backend_api.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentResponseSuccessConsumer {

    private PaymentFacade paymentFacade;

    public PaymentResponseSuccessConsumer(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @RabbitListener(queues = {"payment-response-success-queue"})
    public void receiveMessage(@Payload Message message) {
        System.out.println("Message: " + message);
        String payload = String.valueOf(message.getPayload());

        paymentFacade.successPayment(payload);
    }
}