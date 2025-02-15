package com.example.hubNet.DTO.eCommerce;

import com.example.hubNet.entities.eCommerce.enums.DiscountType;
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
