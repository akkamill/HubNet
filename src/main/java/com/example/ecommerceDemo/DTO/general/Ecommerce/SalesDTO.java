package com.example.ecommerceDemo.DTO.general.Ecommerce;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalesDTO {

    private Long salesId;
    private BigDecimal profit;
    private BigDecimal income;
    private BigDecimal expenses;
    private LocalDateTime saleDate;
    private Long userId;

}
