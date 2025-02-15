package com.example.hubNet.services.invoices;

import com.example.hubNet.DTO.invoice.InvoiceCartDTO;
import com.example.hubNet.entities.invoices.InvoiceCartEntity;
import com.example.hubNet.entities.invoices.InvoiceDetailsEntity;
import com.example.hubNet.entities.invoices.InvoiceEntity;
import com.example.hubNet.repositories.invoices.InvoiceCartRepository;
import com.example.hubNet.repositories.invoices.InvoiceRepository;
import com.example.hubNet.services.mappers.invoice.InvoiceCartMappers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceCartService {

    private final InvoiceCartRepository invoiceCartRepository;
    private final InvoiceRepository invoiceRepository;

    public InvoiceCartService(InvoiceCartRepository invoiceCartRepository, InvoiceRepository invoiceRepository) {
        this.invoiceCartRepository = invoiceCartRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public InvoiceCartEntity getOrCreateCart(Long cartId,
                                             String invoiceId,
                                             BigDecimal discount,
                                             BigDecimal taxes) {

        InvoiceEntity invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        InvoiceCartEntity invoiceCartEntity;
        if (cartId != null) {
            return invoiceCartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
        } else {
            invoiceCartEntity = new InvoiceCartEntity();
        }
        BigDecimal subtotal = calculateSubtotal(invoice);

        invoiceCartEntity.setSubTotal(subtotal);
        invoiceCartEntity.setDiscountPrice(discount);
        invoiceCartEntity.setTaxes(taxes);
        invoiceCartEntity.setInvoice(invoice);

        BigDecimal grandTotal = calculateGrandTotal(invoiceCartEntity);
        invoiceCartEntity.setGrandTotal(grandTotal);


        return invoiceCartRepository.save(invoiceCartEntity);
    }

    @Transactional
    public void updateInvoiceCart(Long cartId, InvoiceCartDTO cartDTO) {

        InvoiceCartEntity cart = invoiceCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Invoice cart not found " + cartId));

        cart.setDiscountPrice(cartDTO.getDiscountPrice());
        cart.setTaxes(cartDTO.getTaxes());
        cart.setSubTotal(cartDTO.getSubTotal());
        cart.setGrandTotal(cartDTO.getGrandTotal());

        invoiceCartRepository.save(cart);

        InvoiceCartMappers.toDTO(cart);
    }

    @Transactional
    public void deleteInvoiceCart(Long cartId) {
        invoiceCartRepository.deleteById(cartId);
    }

    @Transactional
    public InvoiceCartDTO getInvoiceCart(Long cartId) {

        InvoiceCartEntity cart = invoiceCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Invoice cart not found " + cartId));

        return InvoiceCartMappers.toDTO(cart);

    }

    //    ---------------------------Calculation----------------------------------------------------------------------//
    private BigDecimal calculateSubtotal(InvoiceEntity invoice) {
        List<InvoiceDetailsEntity> details = invoice.getInvoiceDetails();
        BigDecimal subtotal = BigDecimal.ZERO;
        for (InvoiceDetailsEntity detail : details) {
            BigDecimal totalPrice = detail.getTotalPrice();
            if (totalPrice != null) {
                subtotal = subtotal.add(totalPrice);
            }
        }
        return subtotal;
    }

    private BigDecimal calculateGrandTotal(InvoiceCartEntity invoiceCart) {
        BigDecimal subtotal = invoiceCart.getSubTotal();
        BigDecimal taxes = invoiceCart.getTaxes();
        BigDecimal discount = invoiceCart.getDiscountPrice();

        return subtotal.add(taxes).subtract(discount);
    }
    //    ------------------------------------------------------------------------------------------------------------//

}

//@Transactional
//    public InvoiceCartDTO getInvoiceCart(Long invoiceCartId) {
//        InvoiceCartEntity invoiceCartEntity = invoiceCartRepository.findById(invoiceCartId)
//                .orElseThrow(() -> new RuntimeException("Invoice cart not found"));
//
//        InvoiceCartDTO invoiceCartDTO = new InvoiceCartDTO();
//        invoiceCartDTO.setInvoiceCartId(invoiceCartDTO.getInvoiceCartId());
//        invoiceCartDTO.setSubTotal(invoiceCartEntity.getSubTotal());
//        invoiceCartDTO.setDiscountPrice(invoiceCartEntity.getDiscountPrice());
//        invoiceCartDTO.setTaxes(invoiceCartEntity.getTaxes());
//        invoiceCartDTO.setGrandTotal(invoiceCartEntity.getGrandTotal());
//
//        return invoiceCartDTO;
//    }

//    @Transactional
//    public InvoiceCartDTO createInvoiceCart(Long detailId, InvoiceCartDTO invoiceCartDTO) {
//
//        InvoiceDetailsEntity invoiceDetailsEntity = invoiceDetailsRepository.findById(detailId)
//                .orElseThrow(() -> new RuntimeException("Details not found"));
//
//        InvoiceCartEntity invoiceCartEntity = new InvoiceCartEntity();
//        invoiceCartEntity.getDetails().add(invoiceDetailsEntity);
//
//        BigDecimal subTotal = invoiceDetailsEntity.getTotalPrice();
//        invoiceCartEntity.setSubTotal(subTotal);
//
//        invoiceCartEntity.setDiscountPrice(invoiceCartDTO.getDiscountPrice());
//        invoiceCartEntity.setTaxes(invoiceCartDTO.getTaxes());
//
//        BigDecimal grandTotal = subTotal
//                .subtract(invoiceCartDTO.getDiscountPrice())
//                .add(invoiceCartDTO.getTaxes());
//        invoiceCartEntity.setGrandTotal(grandTotal);
//
//        invoiceCartEntity = invoiceCartRepository.save(invoiceCartEntity);
//
//
//        return InvoiceCartMappers.toDTO(invoiceCartEntity);
//
//    }

//   @Transactional
//    public InvoiceCartEntity CreateInvoiceCart(Long cartId,
//                                               List<InvoiceDetailsEntity> details,
//                                               BigDecimal discount,
//                                               BigDecimal taxes) {
//        InvoiceCartEntity invoiceCartEntity;
//        if (cartId != null) {
//            invoiceCartEntity = invoiceCartRepository.findById(cartId)
//                    .orElseThrow(() -> new RuntimeException("Cart not found"));
//        } else {
//            invoiceCartEntity = new InvoiceCartEntity();
//        }
//
//        if (details != null && !details.isEmpty()) {
//            invoiceCartEntity.setDetails(details);
//
//            BigDecimal subTotal = calculateSubTotal(details);
//            invoiceCartEntity.setSubTotal(subTotal);
//
//            invoiceCartEntity.setDiscountPrice(discount);
//            invoiceCartEntity.setTaxes(taxes);
//
//            BigDecimal grandTotal = subTotal.subtract(discount).add(taxes);
//            invoiceCartEntity.setGrandTotal(grandTotal);
//        }
//        return invoiceCartRepository.save(invoiceCartEntity);
//    }
//
//    private BigDecimal calculateSubTotal(List<InvoiceDetailsEntity> details) {
//        BigDecimal subTotal = BigDecimal.ZERO;
//
//        for (InvoiceDetailsEntity detail : details) {
//            BigDecimal totalPrice = detail.getTotalPrice();
//            if (totalPrice != null) {
//                subTotal = subTotal.add(totalPrice);
//            }
//        }
//        return subTotal;
//    }

//   @Transactional
//    public InvoiceCartDTO createInvoiceCart(Long detailId, InvoiceCartDTO invoiceCartDTO) {
//        // Fetch the invoice details by ID
//        InvoiceDetailsEntity invoiceDetailsEntity = invoiceDetailsRepository.findById(detailId)
//                .orElseThrow(() -> new RuntimeException("Invoice details not found"));
//
//        // Create a new invoice cart entity
//        InvoiceCartEntity invoiceCartEntity = new InvoiceCartEntity();
//
////        // Add the invoice details to the invoice cart
////        invoiceCartEntity.getDetails().add(invoiceDetailsEntity);
//
//        // Calculate the subtotal based on the total price of the invoice details
//        BigDecimal subTotal = invoiceDetailsEntity.getTotalPrice();
//
//        // Apply the provided discount and taxes
//        invoiceCartEntity.setDiscountPrice(invoiceCartDTO.getDiscountPrice());
//        invoiceCartEntity.setTaxes(invoiceCartDTO.getTaxes());
//
//        // Calculate the grand total by subtracting discount and adding taxes
//        BigDecimal grandTotal = subTotal.subtract(discount).add(taxes);
//        invoiceCartEntity.setGrandTotal(grandTotal);
//
//        // Save the invoice cart entity
//        invoiceCartEntity = invoiceCartRepository.save(invoiceCartEntity);
//
//        return InvoiceCartMappers.toDTO(invoiceCartEntity);
//    }
//}

//    public void getOrCreateCart(Long cartId,
//                                List<InvoiceDetailsEntity> invoiceDetails) {
//
//        // Retrieve the invoice entity using the provided invoiceId
//        InvoiceEntity invoice = invoiceRepository.findById(invoiceId)
//                .orElseThrow(() -> new RuntimeException("Invoice not found"));
//
//        InvoiceCartEntity invoiceCartEntity;
//        if (cartId != null) {
//            // If cartId is provided, retrieve the existing cart entity
//            invoiceCartEntity = invoiceCartRepository.findById(cartId)
//                    .orElseThrow(() -> new RuntimeException("Cart not found"));
//        } else {
//            // If cartId is not provided, create a new cart entity
//            invoiceCartEntity = new InvoiceCartEntity();
//        }
//
//        // Set details and calculate subtotal
//        if (!invoice.getInvoiceDetails().isEmpty()) {
////            invoiceCartEntity.setDetails(invoice.getInvoiceDetails());
//            BigDecimal subTotal = calculateSubtotal(invoice);
//            invoiceCartEntity.setSubTotal(subTotal);
//        }
//
//        // Save or update the invoice cart entity
//        invoiceCartRepository.save(invoiceCartEntity);
//    }