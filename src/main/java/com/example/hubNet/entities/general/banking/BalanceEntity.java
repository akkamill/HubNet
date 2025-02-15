package com.example.hubNet.entities.general.banking;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.enums.ExpensesCategories;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "banking_balance")
@Data
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;

    private BigDecimal income;
    private BigDecimal expense;
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    private ExpensesCategories expensesCategories;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private UserEntity user;


}
