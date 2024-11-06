package com.example.ecommerceDemo.entities.general.Ecommerce;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "balance")
@Data
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;

    private BigDecimal totalBalance;
    private BigDecimal sentAmount;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private UserEntity user;


}
