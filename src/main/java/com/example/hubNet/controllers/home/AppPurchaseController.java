package com.example.hubNet.controllers.home;

import com.example.hubNet.DTO.home.PurchaseAndPayment;
import com.example.hubNet.services.home.AppPurchaseService;
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
