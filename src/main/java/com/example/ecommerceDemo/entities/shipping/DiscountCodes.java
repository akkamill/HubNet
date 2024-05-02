package com.example.ecommerceDemo.entities.shipping;

import com.example.ecommerceDemo.enums.DiscountType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class DiscountCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    private String discountCode;
    private BigDecimal discountAmount;
    private int usageLimit;
    private int usageCount;

    @CreationTimestamp
    private LocalDateTime expirationDate;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;


}
