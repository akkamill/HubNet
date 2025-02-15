package com.example.hubNet.DTO.eCommerce;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDTO {

    private Long cartItemId;
    private Long productId;
    private String productName;
    private  int quantity;
    private BigDecimal productTotalPrice;



}
