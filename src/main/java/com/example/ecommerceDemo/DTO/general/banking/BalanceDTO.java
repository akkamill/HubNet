package com.example.ecommerceDemo.DTO.general.banking;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.enums.ExpensesCategories;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BalanceDTO {

    private Long balanceId;
    private BigDecimal income;
    private BigDecimal expense;
    private BigDecimal currentBalance;
    private ExpensesCategories expensesCategories;
    private LocalDateTime createdAt;
    private UserEntity user;

}
