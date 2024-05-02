package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.enums.InvoiceStatus;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class InvoiceDTO {

    private Long invoiceId;
    private String invoiceTitle;
    private String invoiceDescription;
    private String serviceType;
    private int invoiceQuantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private InvoiceStatus invoiceStatus;
    private LocalDateTime invoiceCreated;
    private UserDTO userDTO;
    private InvoiceCartDTO invoiceCartDTO;
}
