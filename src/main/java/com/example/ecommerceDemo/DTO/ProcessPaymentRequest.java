package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.PaymentEntity;
import lombok.Data;

@Data
public class ProcessPaymentRequest {
    private PaymentEntity paymentEntity;
    private DebitCardDTO debitCardDTO;

}