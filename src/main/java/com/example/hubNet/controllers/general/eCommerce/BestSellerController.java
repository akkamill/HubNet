package com.example.hubNet.controllers.general.eCommerce;

import com.example.hubNet.services.general.Ecommerce.BestSellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/general")
public class BestSellerController {

    private final BestSellerService bestSellerService;

    public BestSellerController(BestSellerService bestSellerService) {
        this.bestSellerService = bestSellerService;
    }

    @GetMapping("/get/best-sellers")
    public ResponseEntity<?> getBestSeller() {
        return ResponseEntity.ok(bestSellerService.getBestSeller());
    }
}
