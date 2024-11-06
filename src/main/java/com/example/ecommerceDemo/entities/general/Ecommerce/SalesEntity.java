package com.example.ecommerceDemo.entities.general.Ecommerce;


import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "sales")
@Data
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesId;

    private BigDecimal profit;
    private BigDecimal income;
    private BigDecimal expenses;

    @CreationTimestamp
    private LocalDateTime saleDate;

    @ManyToOne
    private UserEntity user;
}
