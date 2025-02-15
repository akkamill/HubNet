package com.example.hubNet.repositories.invoices;

import com.example.hubNet.entities.invoices.InvoiceCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceCartRepository extends JpaRepository<InvoiceCartEntity, Long> {

}
