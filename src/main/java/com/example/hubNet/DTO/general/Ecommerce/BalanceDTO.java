package com.example.hubNet.DTO.general.Ecommerce;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BalanceDTO {

    private Long balanceId;
    private BigDecimal totalBalance;
    private BigDecimal sentAmount;
    private Long userId;
    private LocalDateTime createdAt;


}
