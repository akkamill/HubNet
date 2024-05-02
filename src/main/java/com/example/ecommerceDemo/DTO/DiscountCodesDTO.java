package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.enums.DiscountType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DiscountCodesDTO {

    private Long discountId;
    private String discountCode;
    private BigDecimal discountAmount;
    private int usageLimit;
    private LocalDateTime expirationDate;
    private DiscountType discountType;

}
