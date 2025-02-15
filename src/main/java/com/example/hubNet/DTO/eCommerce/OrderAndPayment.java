package com.example.hubNet.DTO.eCommerce;

import com.example.hubNet.DTO.others.ProcessPaymentRequest;
import lombok.Data;

@Data
public class OrderAndPayment {

    private OrderDTO orderDTO;
    private ProcessPaymentRequest processPaymentRequest;
}
