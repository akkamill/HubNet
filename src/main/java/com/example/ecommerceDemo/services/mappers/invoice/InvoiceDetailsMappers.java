package com.example.ecommerceDemo.services.mappers.invoice;

import com.example.ecommerceDemo.DTO.invoice.InvoiceDetailsDTO;
import com.example.ecommerceDemo.entities.invoices.InvoiceDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDetailsMappers {

    public static InvoiceDetailsDTO toDTO(InvoiceDetailsEntity invoiceDetailsEntity) {

        InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO();

        invoiceDetailsDTO.setInvoiceTitle(invoiceDetailsEntity.getInvoiceTitle());
        invoiceDetailsDTO.setInvoiceDescription(invoiceDetailsEntity.getInvoiceDescription());
        invoiceDetailsDTO.setServiceType(invoiceDetailsEntity.getServiceType());
        invoiceDetailsDTO.setInvoiceQuantity(invoiceDetailsEntity.getInvoiceQuantity());
        invoiceDetailsDTO.setUnitPrice(invoiceDetailsEntity.getUnitPrice());
        invoiceDetailsDTO.setTotalPrice(invoiceDetailsEntity.getTotalPrice());

        invoiceDetailsDTO.setInvoiceDTO(InvoiceMappers.toDTO(invoiceDetailsEntity.getInvoiceEntity()));


        return invoiceDetailsDTO;
    }

    public static InvoiceDetailsEntity toEntity(InvoiceDetailsDTO invoiceDetailsDTO) {

        InvoiceDetailsEntity invoiceDetailsEntity = new InvoiceDetailsEntity();
        invoiceDetailsEntity.setInvoiceTitle(invoiceDetailsDTO.getInvoiceTitle());
        invoiceDetailsEntity.setInvoiceDescription(invoiceDetailsDTO.getInvoiceDescription());
        invoiceDetailsEntity.setServiceType(invoiceDetailsDTO.getServiceType());
        invoiceDetailsEntity.setInvoiceQuantity(invoiceDetailsDTO.getInvoiceQuantity());
        invoiceDetailsEntity.setUnitPrice(invoiceDetailsDTO.getUnitPrice());
        invoiceDetailsEntity.setTotalPrice(invoiceDetailsDTO.getTotalPrice());

        invoiceDetailsEntity.setInvoiceEntity(InvoiceMappers.toEntity(invoiceDetailsDTO.getInvoiceDTO()));

        return invoiceDetailsEntity;

    }

}
