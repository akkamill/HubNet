package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.invoices.InvoiceEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class InvoiceCartDTO {

    private Long invoiceCartId;
    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;
    private BigDecimal InvoiceDiscount;
    private BigDecimal taxes;
    private List<InvoiceDTO> invoiceEntity;



}
