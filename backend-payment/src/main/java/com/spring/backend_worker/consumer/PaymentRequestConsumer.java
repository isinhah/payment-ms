package com.spring.backend_worker.consumer;

import com.spring.backend_worker.producer.PaymentErrorProducer;
import com.spring.backend_worker.producer.PaymentSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentRequestConsumer {

    private PaymentErrorProducer errorProducer;
    private PaymentSuccessProducer successProducer;

    public PaymentRequestConsumer(PaymentErrorProducer errorProducer, PaymentSuccessProducer successProducer) {
        this.errorProducer = errorProducer;
        this.successProducer = successProducer;
    }

    @RabbitListener(queues = {"payment-request-queue"})
    public void receiveMessage(@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()) {
            successProducer.generateResponse("Mensagem de sucesso: " + message);
        } else {
            errorProducer.generateResponse("Mensagem de erro: " + message);
        }
    }
}