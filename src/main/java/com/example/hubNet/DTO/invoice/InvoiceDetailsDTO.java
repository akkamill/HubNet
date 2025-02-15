package com.example.hubNet.DTO.invoice;


import com.example.hubNet.entities.invoices.enums.ServiceType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceDetailsDTO {

    private Long invoiceDetailId;
    private String invoiceTitle;
    private String invoiceDescription;
    private ServiceType serviceType;
    private int invoiceQuantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private InvoiceDTO invoiceDTO;


}
