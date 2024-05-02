package com.example.ecommerceDemo.entities;

import com.example.ecommerceDemo.enums.PaymentMethods;
import com.example.ecommerceDemo.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private BigDecimal paymentAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


    //    private String receiptNumber;


    @CreationTimestamp
    private LocalDateTime createdAt;

}
