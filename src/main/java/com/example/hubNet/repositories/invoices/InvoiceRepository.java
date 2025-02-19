package com.example.hubNet.repositories.invoices;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.invoices.InvoiceEntity;
import com.example.hubNet.entities.invoices.enums.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String> {



    List<InvoiceEntity> findByInvoiceStatus(InvoiceStatus invoiceStatus);

    List<InvoiceEntity> findByDueDateIsBetween(LocalDate createDate, LocalDate dueDate);

    List<InvoiceEntity> findByRecipientInvoice(List<UserEntity> recipientInvoice);

    List<InvoiceEntity> findByDueDateBeforeAndInvoiceStatusNot(LocalDate currentDate, InvoiceStatus invoiceStatus);




}
