package com.example.hubNet.DTO.invoice;

import com.example.hubNet.entities.invoices.enums.InvoiceStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InvoiceDTO {

    private String invoiceId;
    private InvoiceStatus invoiceStatus;
    private LocalDate createDate;
    private LocalDate dueDate;
    private Long invoiceSender;
    private List<Long> invoiceRecipient;
    private InvoiceCartDTO invoiceCart;


}
