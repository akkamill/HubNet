package com.example.ecommerceDemo.services.invoices;

import com.example.ecommerceDemo.DTO.invoice.InvoiceDetailsDTO;
import com.example.ecommerceDemo.entities.invoices.InvoiceDetailsEntity;
import com.example.ecommerceDemo.entities.invoices.InvoiceEntity;
import com.example.ecommerceDemo.entities.invoices.enums.ServiceType;
import com.example.ecommerceDemo.repositories.invoices.InvoiceDetailsRepository;
import com.example.ecommerceDemo.repositories.invoices.InvoiceRepository;
import com.example.ecommerceDemo.services.mappers.invoice.InvoiceDetailsMappers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailsService {

    private final InvoiceDetailsRepository invoiceDetailsRepository;
    private final InvoiceRepository invoiceRepository;

    public InvoiceDetailsService(InvoiceDetailsRepository invoiceDetailsRepository, InvoiceRepository invoiceRepository) {
        this.invoiceDetailsRepository = invoiceDetailsRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public void createInvoiceDetails(String invoiceId, InvoiceDetailsDTO invoiceDetailsDTO) {

        InvoiceEntity invoiceEntity = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));


        InvoiceDetailsEntity invoiceDetailsEntity = new InvoiceDetailsEntity();
        invoiceDetailsEntity.setInvoiceEntity(invoiceEntity);
        invoiceDetailsEntity.setInvoiceTitle(invoiceDetailsDTO.getInvoiceTitle());
        invoiceDetailsEntity.setInvoiceDescription(invoiceDetailsDTO.getInvoiceDescription());
        invoiceDetailsEntity.setServiceType(invoiceDetailsDTO.getServiceType());
        invoiceDetailsEntity.setInvoiceQuantity(invoiceDetailsDTO.getInvoiceQuantity());
        invoiceDetailsEntity.setUnitPrice(invoiceDetailsDTO.getUnitPrice());

        BigDecimal totalPrice = invoiceDetailsEntity.getUnitPrice()
                .multiply(BigDecimal.valueOf(invoiceDetailsDTO.getInvoiceQuantity()));
        invoiceDetailsEntity.setTotalPrice(totalPrice);

        InvoiceDetailsEntity savedDetails = invoiceDetailsRepository.save(invoiceDetailsEntity);

        InvoiceDetailsMappers.toDTO(savedDetails);
    }

    @Transactional
    public List<InvoiceDetailsDTO> getAllInvoiceDetails() {
        List<InvoiceDetailsEntity> entities = invoiceDetailsRepository.findAll();
        List<InvoiceDetailsDTO> dtoList = new ArrayList<>();
        for (InvoiceDetailsEntity i : entities) {
            InvoiceDetailsDTO detailsDTO = InvoiceDetailsMappers.toDTO(i);
            dtoList.add(detailsDTO);
        }
        return dtoList;
    }

    @Transactional
    public InvoiceDetailsDTO getInvoiceDetails(Long detailsId) {
        InvoiceDetailsEntity detailsEntity = invoiceDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new RuntimeException("Details not found"));

        return InvoiceDetailsMappers.toDTO(detailsEntity);
    }

    @Transactional
    public void updateInvoiceDetails(Long detailsId, InvoiceDetailsDTO detailsDTO) {
        InvoiceDetailsEntity details = invoiceDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new RuntimeException("Details not found " + detailsId));

                details.setInvoiceDescription(detailsDTO.getInvoiceDescription());
                details.setInvoiceQuantity(detailsDTO.getInvoiceQuantity());
                details.setServiceType(detailsDTO.getServiceType());
                details.setInvoiceTitle(detailsDTO.getInvoiceTitle());
                details.setUnitPrice(detailsDTO.getUnitPrice());

                invoiceDetailsRepository.save(details);
    }

    @Transactional
    public void deleteInvoiceDetails(Long detailsId){
        invoiceDetailsRepository.deleteById(detailsId);
    }

    @Transactional
    public List<InvoiceDetailsEntity> filterByServiceType(ServiceType serviceType) {
        return invoiceDetailsRepository.findInvoiceDetailsEntitiesByServiceType(serviceType);
    }




}
