//package com.example.ecommerceDemo.entities.invoices;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//
//@Data
//@Entity
//public class InvoiceDiscounts {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long discountId;
//
//    private String discountCode;
//    private BigDecimal discountAmount;
//    private int usageLimit;
//    private int usageCount;
//
//    @CreationTimestamp
//    private LocalDateTime expirationDate;
//}
