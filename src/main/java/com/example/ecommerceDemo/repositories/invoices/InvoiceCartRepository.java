package com.example.ecommerceDemo.repositories.invoices;

import com.example.ecommerceDemo.entities.invoices.InvoiceCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceCartRepository extends JpaRepository<InvoiceCartEntity, Long> {

}
