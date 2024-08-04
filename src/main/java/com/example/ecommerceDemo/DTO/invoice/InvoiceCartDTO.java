package com.example.ecommerceDemo.DTO.invoice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceCartDTO {

    private Long invoiceCartId;
    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;
    private BigDecimal taxes;
    private InvoiceDTO invoiceDTO;



}
