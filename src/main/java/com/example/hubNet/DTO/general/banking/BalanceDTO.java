package com.example.hubNet.DTO.general.banking;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.enums.ExpensesCategories;
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
