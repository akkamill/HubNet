package com.example.hubNet.DTO.eCommerce;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private Long orderItemId;
    private String productName;
    private int quantity;
    private BigDecimal totalPrice;

}
