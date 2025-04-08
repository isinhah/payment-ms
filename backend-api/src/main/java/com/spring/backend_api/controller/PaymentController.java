package com.spring.backend_api.controller;

import com.spring.backend_api.dto.PaymentDto;
import com.spring.backend_api.facade.PaymentFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private PaymentFacade paymentFacade;

    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @PostMapping
    public String processPayment(@RequestBody PaymentDto request) {
        return paymentFacade.requestPayment(request);
    }
}
