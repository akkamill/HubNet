package com.example.ecommerceDemo.controllers.home;

import com.example.ecommerceDemo.DTO.home.PurchaseAndPayment;
import com.example.ecommerceDemo.services.home.AppPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
public class AppPurchaseController {

    private final AppPurchaseService appPurchaseService;

    public AppPurchaseController(AppPurchaseService appPurchaseService) {
        this.appPurchaseService = appPurchaseService;
    }


    @PostMapping("/purchase/{userId}")
    public ResponseEntity<String> makePurchase(
            @PathVariable Long userId,
            @RequestBody PurchaseAndPayment purchaseAndPayment) {
        try {
            appPurchaseService.purchaseAndPay(userId, purchaseAndPayment);
            return ResponseEntity.ok("Purchase and payment completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to complete purchase and payment: " + e.getMessage());
        }
    }
}
