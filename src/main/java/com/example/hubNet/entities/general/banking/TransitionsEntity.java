package com.example.hubNet.entities.general.banking;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.enums.Status;
import com.example.hubNet.enums.TransactionSide;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "transitions")
@Data
public class TransitionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transitionId;

    private String name;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionSide paymentSide;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @CreationTimestamp
    private LocalDate processTime;

    @ManyToOne
    private UserEntity user;
}
