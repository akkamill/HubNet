package com.example.ecommerceDemo.DTO.eCommerce;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDTO {


    private Long cartId;
    private List<CartItemDTO> cartItems;
    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;

}
