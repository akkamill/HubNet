package com.example.ecommerceDemo.services.mappers.invoice;

import com.example.ecommerceDemo.DTO.invoice.InvoiceDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.invoices.InvoiceEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceMappers {

    public static InvoiceDTO toDTO(InvoiceEntity invoiceEntity) {

        if (invoiceEntity == null) {
            return null;
        }

        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceId(invoiceEntity.getInvoiceId());
        invoiceDTO.setInvoiceStatus(invoiceEntity.getInvoiceStatus());
        invoiceDTO.setCreateDate(invoiceEntity.getCreateDate());
        invoiceDTO.setDueDate(invoiceEntity.getDueDate());

        invoiceDTO.setInvoiceSender(invoiceEntity.getInvoiceSender().getUserId());

        List<Long> recipientIds = new ArrayList<>();
        for (UserEntity recipient : invoiceEntity.getRecipientInvoice()) {
            recipientIds.add(recipient.getUserId());
        }
        invoiceDTO.setInvoiceRecipient(recipientIds);

//        if (invoiceEntity.getInvoiceCart() != null) {
//            invoiceDTO.setInvoiceCart(InvoiceCartMappers.toDTO(invoiceEntity.getInvoiceCart()));
//        }

        return invoiceDTO;
    }


    public static InvoiceEntity toEntity(InvoiceDTO invoiceDTO) {

        if (invoiceDTO == null) {
            return null;
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setInvoiceId(invoiceDTO.getInvoiceId());
        invoiceEntity.setInvoiceStatus(invoiceDTO.getInvoiceStatus());
        invoiceEntity.setCreateDate(invoiceDTO.getCreateDate());
        invoiceEntity.setDueDate(invoiceDTO.getDueDate());

        UserEntity sender = new UserEntity();
        sender.setUserId(invoiceDTO.getInvoiceSender());
        invoiceEntity.setInvoiceSender(sender);

        List<UserEntity> recipients = new ArrayList<>();
        for (Long recipientId : invoiceDTO.getInvoiceRecipient()) {
            UserEntity recipient = new UserEntity();
            recipient.setUserId(recipientId);
            recipients.add(recipient);
        }
        invoiceEntity.setRecipientInvoice(recipients);

//        InvoiceCartDTO invoiceCartDTO = invoiceDTO.getInvoiceCart();
//        if (invoiceCartDTO != null) {
//            invoiceEntity.setInvoiceCart(InvoiceCartMappers.toEntity(invoiceCartDTO));
//        }


        return invoiceEntity;
    }
}
