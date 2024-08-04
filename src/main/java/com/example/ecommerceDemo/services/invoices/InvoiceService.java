package com.example.ecommerceDemo.services.invoices;

import com.example.ecommerceDemo.DTO.invoice.InvoiceDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.invoices.InvoiceEntity;
import com.example.ecommerceDemo.entities.invoices.enums.InvoiceStatus;
import com.example.ecommerceDemo.repositories.invoices.InvoiceRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.services.mappers.invoice.InvoiceMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;


    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public void createInvoice(InvoiceDTO invoiceDTO) {

        UserEntity sender = userRepository.findById(invoiceDTO.getInvoiceSender()).orElseThrow(()
                -> new RuntimeException("Sender not found"));

        List<UserEntity> recipients = new ArrayList<>();
        for (Long recipientInvoice : invoiceDTO.getInvoiceRecipient()) {
            UserEntity recipient = userRepository.findById(recipientInvoice).orElseThrow(()
                    -> new RuntimeException("Recipient not found"));
            recipients.add(recipient);
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();

        invoiceEntity.setCreateDate(invoiceDTO.getCreateDate());
        invoiceEntity.setDueDate(invoiceDTO.getDueDate());
        invoiceEntity.setInvoiceStatus(invoiceDTO.getInvoiceStatus());
        invoiceEntity.setInvoiceSender(sender);
        invoiceEntity.setRecipientInvoice(recipients);
        invoiceEntity.setInvoiceStatus(InvoiceStatus.UNPAID);

        InvoiceEntity savedInvoiceEntity = invoiceRepository.save(invoiceEntity);

        InvoiceMappers.toDTO(savedInvoiceEntity);

    }

    @Transactional
    public void saveInvoiceAsDraft(InvoiceEntity invoiceEntity) {
        invoiceEntity.setInvoiceStatus(InvoiceStatus.DRAFT);

        invoiceRepository.save(invoiceEntity);
    }

    @Transactional
    public void markInvoiceAsPaid(String invoiceId) {

        Optional<InvoiceEntity> invoiceOptional = invoiceRepository.findById(invoiceId);
        if(invoiceOptional.isPresent()) {
            InvoiceEntity invoice = invoiceOptional.get();

            invoice.setInvoiceStatus(InvoiceStatus.PAID);

            invoiceRepository.save(invoice);
        } else {
            throw new RuntimeException("Invoice not found with id " + invoiceId);
        }


    }

    @Transactional
    public void deleteInvoice(String invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }

    @Transactional
    public void updateInvoice(String invoiceId, InvoiceDTO invoiceDTO) {
        InvoiceEntity invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        invoice.setCreateDate(invoiceDTO.getCreateDate());
        invoice.setDueDate(invoiceDTO.getDueDate());
        invoice.setInvoiceStatus(invoiceDTO.getInvoiceStatus());
    }

    @Transactional
    public List<InvoiceDTO> getAllInvoices(){
        List<InvoiceEntity> entities = invoiceRepository.findAll();
        List<InvoiceDTO> dtoList = new ArrayList<>();
        for (InvoiceEntity ie : entities) {
            InvoiceDTO invoiceDTO = InvoiceMappers.toDTO(ie);
            dtoList.add(invoiceDTO);
        }
        return dtoList;
    }

    @Transactional
    public InvoiceDTO getInvoice(String invoiceId) {
        InvoiceEntity invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        return InvoiceMappers.toDTO(invoice);
    }

    @Transactional
    public List<InvoiceEntity> filterByStatus(InvoiceStatus status) {
        return invoiceRepository.findByInvoiceStatus(status);
    }

    @Transactional
    public List<InvoiceEntity> filterByUser(Long userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return invoiceRepository.findByRecipientInvoice(List.of(user));
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
    @Transactional
    public List<InvoiceEntity> filterByDueDateRange(LocalDate createDate, LocalDate dueDate) {
        return invoiceRepository.findByDueDateIsBetween(createDate, dueDate);
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void updateInvoiceStatus() {
        LocalDate currentDate = LocalDate.now();
        List<InvoiceEntity> overdueInvoices = invoiceRepository
                .findByDueDateBeforeAndInvoiceStatusNot(currentDate, InvoiceStatus.PAID);

        for (InvoiceEntity invoice : overdueInvoices) {
            invoice.setInvoiceStatus(InvoiceStatus.OVERDUE);
            invoiceRepository.save(invoice);
        }
    }

}
