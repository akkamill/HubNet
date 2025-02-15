package com.example.hubNet.entities.invoices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "invoice_cart")
public class InvoiceCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceCartId;

    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;
    private BigDecimal taxes;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

}
