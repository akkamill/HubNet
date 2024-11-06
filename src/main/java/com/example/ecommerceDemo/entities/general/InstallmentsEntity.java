package com.example.ecommerceDemo.entities.general;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "installments")
public class InstallmentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long installmentId;

    private String countries;
    private String platforms;
    private String mainlands;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
