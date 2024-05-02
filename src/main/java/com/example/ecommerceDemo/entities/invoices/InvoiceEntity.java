package com.example.ecommerceDemo.entities.invoices;

import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.enums.InvoiceStatus;
import com.example.ecommerceDemo.enums.InvoiceType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class InvoiceEntity {

    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.example.ecommerceDemo.entities.invoices")
    private Long invoiceId;

    private String invoiceTitle;
    private String invoiceDescription;
    private String serviceType;
    private int invoiceQuantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private InvoiceStatus invoiceStatus;

    @CreationTimestamp
    private LocalDateTime invoiceCreated;

    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    private InvoiceCartEntity invoiceCartEntity;


}
