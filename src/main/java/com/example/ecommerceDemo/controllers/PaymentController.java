package com.example.ecommerceDemo.controllers;


import com.example.ecommerceDemo.DTO.DebitCardDTO;
import com.example.ecommerceDemo.DTO.ProcessPaymentRequest;
import com.example.ecommerceDemo.entities.PaymentEntity;
import com.example.ecommerceDemo.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentEntity> processPayment(@RequestBody ProcessPaymentRequest request) {
        PaymentEntity processPayment = paymentService.processPayment(
                request.getPaymentEntity(),
                request.getDebitCardDTO());
        return ResponseEntity.ok(processPayment);
    }
}
