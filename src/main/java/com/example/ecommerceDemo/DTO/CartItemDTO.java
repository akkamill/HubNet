package com.example.ecommerceDemo.DTO;


import com.example.ecommerceDemo.entities.ProductEntity;
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
