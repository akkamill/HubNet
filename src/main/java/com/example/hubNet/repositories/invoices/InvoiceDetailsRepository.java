package com.example.hubNet.repositories.invoices;

import com.example.hubNet.entities.invoices.InvoiceDetailsEntity;
import com.example.hubNet.entities.invoices.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetailsEntity, Long> {

    List<InvoiceDetailsEntity> findInvoiceDetailsEntitiesByServiceType(ServiceType serviceType);
}
