package com.example.hubNet.DTO.others;

import com.example.hubNet.entities.others.PaymentEntity;
import lombok.Data;

@Data
public class ProcessPaymentRequest {

    private PaymentEntity paymentEntity;
    private DebitCardDTO debitCardDTO;

}