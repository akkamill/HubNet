package com.example.ecommerceDemo.repositories.invoices;

import com.example.ecommerceDemo.entities.invoices.InvoiceDetailsEntity;
import com.example.ecommerceDemo.entities.invoices.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetailsEntity, Long> {

    List<InvoiceDetailsEntity> findInvoiceDetailsEntitiesByServiceType(ServiceType serviceType);
}
