package com.example.hubNet.controllers.invoice;

import com.example.hubNet.DTO.invoice.InvoiceDetailsDTO;
import com.example.hubNet.entities.invoices.InvoiceDetailsEntity;
import com.example.hubNet.entities.invoices.enums.ServiceType;
import com.example.hubNet.services.invoices.InvoiceDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-details")
public class InvoiceDetailsController {

    private final InvoiceDetailsService invoiceDetailsService;

    public InvoiceDetailsController(InvoiceDetailsService invoiceDetailsService) {
        this.invoiceDetailsService = invoiceDetailsService;
    }


    @PostMapping("/create/{invoiceId}")
    public ResponseEntity<?> createInvoiceDetails(@PathVariable String invoiceId,
                                                  @RequestBody InvoiceDetailsDTO detailsDTO) {
        invoiceDetailsService.createInvoiceDetails(invoiceId, detailsDTO);
        return ResponseEntity.ok("Created!");
    }

    @PutMapping("/update/{detailsId}")
    public ResponseEntity<?> updateInvoiceDetails(@PathVariable Long detailsId,
                                                  @RequestBody InvoiceDetailsDTO detailsDTO) {
        invoiceDetailsService.updateInvoiceDetails(detailsId, detailsDTO);
        return ResponseEntity.ok("Details has been updated " + detailsDTO);
    }

    @DeleteMapping("/delete/{detailsId}")
    public ResponseEntity<?> deleteInvoiceDetails(@PathVariable Long detailsId) {
        invoiceDetailsService.deleteInvoiceDetails(detailsId);
        return ResponseEntity.ok("Details has been deleted " + detailsId);
    }

    @GetMapping("/get-details/{detailsId}")
    public ResponseEntity<InvoiceDetailsDTO> getInvoiceDetails(@PathVariable Long detailsId) {
        return ResponseEntity.ok(invoiceDetailsService.getInvoiceDetails(detailsId));
    }

    @GetMapping("/get-all-details")
    public ResponseEntity<List<InvoiceDetailsDTO>> getAllInvoiceDetails() {
        return ResponseEntity.ok(invoiceDetailsService.getAllInvoiceDetails());
    }

    @GetMapping("/filter-by-service-type/{serviceType}")
    public ResponseEntity<List<InvoiceDetailsEntity>> filterBysServiceType(@PathVariable ServiceType serviceType) {
        List<InvoiceDetailsEntity> filteredInvoices = invoiceDetailsService.filterByServiceType(serviceType);
        return new ResponseEntity<>(filteredInvoices, HttpStatus.OK);
    }
}
