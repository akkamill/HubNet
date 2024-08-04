package com.example.ecommerceDemo.DTO.eCommerce;

import com.example.ecommerceDemo.entities.eCommerce.enums.DiscountType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DiscountCodesDTO {

    private Long discountId;
    private String discountCode;
    private BigDecimal discountAmount;
    private int usageLimit;
    private LocalDateTime expirationDate;
    private DiscountType discountType;

}
