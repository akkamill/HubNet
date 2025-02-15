package com.example.hubNet.controllers.invoice;

import com.example.hubNet.DTO.invoice.InvoiceCartDTO;
import com.example.hubNet.entities.invoices.InvoiceCartEntity;
import com.example.hubNet.services.invoices.InvoiceCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/invoice-carts")
public class InvoiceCartController {

    private final InvoiceCartService invoiceCartService;

    public InvoiceCartController(InvoiceCartService invoiceCartService) {
        this.invoiceCartService = invoiceCartService;
    }

    @GetMapping("/get-or-create")
    public ResponseEntity<InvoiceCartEntity> getOrCreateCart(
            @RequestParam(required = false) Long cartId,
            @RequestParam String invoiceId,
            @RequestParam BigDecimal discount,
            @RequestParam BigDecimal taxes) {
        InvoiceCartEntity cart = invoiceCartService.getOrCreateCart(cartId, invoiceId, discount, taxes);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<InvoiceCartDTO> updateInvoiceCart(@PathVariable Long cartId,
                                                            @RequestBody InvoiceCartDTO cartDTO) {
        invoiceCartService.updateInvoiceCart(cartId, cartDTO);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<?> deleteInvoiceCart(@PathVariable Long cartId) {
        invoiceCartService.deleteInvoiceCart(cartId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-invoice-cart/{cartId}")
    public ResponseEntity<InvoiceCartDTO> getInvoiceCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(invoiceCartService.getInvoiceCart(cartId));
    }


}



//    @GetMapping("/get/{carId}")
//    public ResponseEntity<InvoiceCartEntity> getCart(@PathVariable Long cartId) {
//        InvoiceCartEntity cart = invoiceCartService.ge
//    }
//
//    @PostMapping("/add-discount-taxes/{invoiceId}")
//    public ResponseEntity<String> addDiscountAndTaxes(@PathVariable String invoiceId,
//                                                      @RequestParam BigDecimal discount,
//                                                      @RequestParam BigDecimal taxes) {
//        try {
//            invoiceCartService.addDiscountAndTaxes(invoiceId, discount, taxes);
//            return ResponseEntity.ok("Discount and taxes added successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add discount and taxes.");
//        }
//    }
//
//}
//
//
//    @PostMapping("/create/{deailId}")
//    public ResponseEntity<?> createInvoiceCart(@PathVariable Long detailId,
//                                               @RequestBody InvoiceCartDTO invoiceCartDTO) {
//        try {
//            InvoiceCartDTO createInvoiceCart = invoiceCartService.createInvoiceCart(detailId, invoiceCartDTO);
//            return ResponseEntity.ok(createInvoiceCart);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<InvoiceCartEntity> createInvoiceCart(
//            @RequestParam(required = false) Long cartId,
//            @RequestBody List<InvoiceDetailsEntity> details) {
//        try {
//            InvoiceCartEntity invoiceCartEntity = invoiceCartService.getOrCreateInvoiceCart(cartId, details);
//            return ResponseEntity.ok(invoiceCartEntity);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<InvoiceCartDTO> createInvoiceCart(
//            @RequestParam Long detailId,
//            @RequestBody InvoiceCartDTO invoiceCartDTO) {
//        try {
//            InvoiceCartDTO createdCart = invoiceCartService.createInvoiceCart(detailId, discount, taxes);
//            return ResponseEntity.ok(createdCart);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createInvoiceCart(@RequestParam(required = false) Long cartId,
//                                               @RequestBody List<InvoiceDetailsEntity> details,
//                                               @RequestParam BigDecimal discount,
//                                               @RequestParam BigDecimal taxes) {
//        try {
//            InvoiceCartEntity invoiceCartEntity = invoiceCartService.CreateInvoiceCart(cartId, details, discount, taxes);
//            return ResponseEntity.ok(invoiceCartEntity);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create invoice cart: " + e.getMessage());
//        }
//    }
//
//}

