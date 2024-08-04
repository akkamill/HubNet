package com.example.ecommerceDemo.services.mappers.invoice;

import com.example.ecommerceDemo.DTO.invoice.InvoiceCartDTO;
import com.example.ecommerceDemo.entities.invoices.InvoiceCartEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceCartMappers {

    public static InvoiceCartDTO toDTO(InvoiceCartEntity invoiceCartEntity) {

        if (invoiceCartEntity == null) {
            return null;
        }

        InvoiceCartDTO invoiceCartDTO = new InvoiceCartDTO();

        invoiceCartDTO.setInvoiceCartId(invoiceCartEntity.getInvoiceCartId());
        invoiceCartDTO.setSubTotal(invoiceCartEntity.getSubTotal());
        invoiceCartDTO.setGrandTotal(invoiceCartEntity.getGrandTotal());
        invoiceCartDTO.setDiscountPrice(invoiceCartEntity.getDiscountPrice());
        invoiceCartDTO.setTaxes(invoiceCartEntity.getTaxes());

//        invoiceCartDTO.setInvoiceDTO(InvoiceMappers.toDTO(invoiceCartEntity.getInvoice()));


        return invoiceCartDTO;
    }

    public static InvoiceCartEntity toEntity(InvoiceCartDTO invoiceCartDTO) {

        if (invoiceCartDTO == null) {
            return null;
        }

        InvoiceCartEntity invoiceCartEntity = new InvoiceCartEntity();

        invoiceCartEntity.setInvoiceCartId(invoiceCartDTO.getInvoiceCartId());
        invoiceCartEntity.setSubTotal(invoiceCartDTO.getSubTotal());
        invoiceCartEntity.setGrandTotal(invoiceCartDTO.getGrandTotal());
        invoiceCartEntity.setDiscountPrice(invoiceCartDTO.getDiscountPrice());
        invoiceCartEntity.setTaxes(invoiceCartDTO.getTaxes());

//        invoiceCartEntity.setInvoice(InvoiceMappers.toEntity(invoiceCartDTO.getInvoiceDTO()));

        return invoiceCartEntity;
    }


}
