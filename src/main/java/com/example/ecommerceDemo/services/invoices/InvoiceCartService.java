package com.example.ecommerceDemo.services.invoices;

import com.example.ecommerceDemo.repositories.InvoiceCartRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceCartService {

    private final InvoiceCartRepository invoiceCartRepository;

    public InvoiceCartService(InvoiceCartRepository invoiceCartRepository) {
        this.invoiceCartRepository = invoiceCartRepository;
    }
}
