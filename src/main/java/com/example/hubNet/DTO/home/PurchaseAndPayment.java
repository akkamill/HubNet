package com.example.hubNet.DTO.home;

import com.example.hubNet.DTO.others.ProcessPaymentRequest;
import lombok.Data;

@Data
public class PurchaseAndPayment {

    private AppPurchaseDTO appPurchaseDTO;
    private ProcessPaymentRequest processPaymentRequest;

}
