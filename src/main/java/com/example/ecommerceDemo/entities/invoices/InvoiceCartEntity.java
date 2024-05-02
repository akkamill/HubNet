package com.example.ecommerceDemo.entities.invoices;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class InvoiceCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceCartId;

    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;
    private BigDecimal InvoiceDiscount;
    private BigDecimal taxes;

    @OneToMany
    private List<InvoiceEntity> invoiceEntity;

}
