package com.example.ecommerceDemo.DTO.others;

import com.example.ecommerceDemo.entities.others.PaymentEntity;
import lombok.Data;

@Data
public class ProcessPaymentRequest {

    private PaymentEntity paymentEntity;
    private DebitCardDTO debitCardDTO;

}