package com.example.ecommerceDemo.DTO.eCommerce;

import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import lombok.Data;

@Data
public class OrderAndPayment {

    private OrderDTO orderDTO;
    private ProcessPaymentRequest processPaymentRequest;
}
