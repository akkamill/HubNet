package com.example.ecommerceDemo.controllers.invoice;


import com.example.ecommerceDemo.DTO.invoice.InvoiceDTO;
import com.example.ecommerceDemo.entities.invoices.InvoiceEntity;
import com.example.ecommerceDemo.entities.invoices.enums.InvoiceStatus;
import com.example.ecommerceDemo.services.invoices.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createInvoice(@ModelAttribute InvoiceDTO invoiceDTO) {
        try {
            invoiceService.createInvoice(invoiceDTO);
            return ResponseEntity.ok("Invoice created");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create invoice " + e.getMessage());
        }
    }

    @PostMapping("/save-as-draft")
    public ResponseEntity<String> saveInvoiceAsDraft(@RequestBody InvoiceEntity invoiceEntity) {
        invoiceService.saveInvoiceAsDraft(invoiceEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Invoice saved as draft successfully.");
    }

    @PostMapping("/mark-as-paid/{invoiceId}")
    public ResponseEntity<?> markInvoiceAsPaid(@PathVariable String invoiceId) {
        invoiceService.markInvoiceAsPaid(invoiceId);
        return ResponseEntity.ok("Invoice marked as PAID " + invoiceId);
    }

    @GetMapping("/get-invoice/{invoiceId}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable String invoiceId) {
        return ResponseEntity.ok(invoiceService.getInvoice(invoiceId));

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PutMapping("/update/{invoiceId}")
    public ResponseEntity<?> updateInvoice(@PathVariable String invoiceId,
                                           @RequestBody InvoiceDTO invoiceDTO) {
        invoiceService.updateInvoice(invoiceId, invoiceDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{invoiceId}")
    public ResponseEntity<?> deleteInvoice(@PathVariable String invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter-by-user/{userId}")
    public ResponseEntity<List<InvoiceEntity>> filterByUser(@PathVariable Long userId) {
        List<InvoiceEntity> filteredInvoices = invoiceService.filterByUser(userId);
        return new ResponseEntity<>(filteredInvoices, HttpStatus.OK);
    }

    @GetMapping("/filter-by-status/{status}")
    public ResponseEntity<List<InvoiceEntity>> filterByStatus(@PathVariable InvoiceStatus status) {
        List<InvoiceEntity> filteredInvoices = invoiceService.filterByStatus(status);
        return new ResponseEntity<>(filteredInvoices, HttpStatus.OK);
    }

    @GetMapping("/filter-by-date")
    public ResponseEntity<List<InvoiceEntity>> filterByDueDateRange(@RequestParam("createDate") LocalDate createDate,
                                                                    @RequestParam("dueDate") LocalDate dueDate) {
        List<InvoiceEntity> filteredInvoice = invoiceService.filterByDueDateRange(createDate, dueDate);
        return new ResponseEntity<>(filteredInvoice, HttpStatus.OK);
    }
}
