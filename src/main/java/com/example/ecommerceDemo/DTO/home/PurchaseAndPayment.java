package com.example.ecommerceDemo.DTO.home;

import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import lombok.Data;

@Data
public class PurchaseAndPayment {

    private AppPurchaseDTO appPurchaseDTO;
    private ProcessPaymentRequest processPaymentRequest;

}
