package com.example.ecommerceDemo.entities.general.banking;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transfer")
@Data
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;

    private BigDecimal insertAmount;

    private Long senderId;
    private Long receiverId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private UserEntity user;
}
