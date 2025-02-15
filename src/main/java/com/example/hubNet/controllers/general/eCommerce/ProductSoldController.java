package com.example.hubNet.controllers.general.eCommerce;

import com.example.hubNet.services.general.Ecommerce.ProductSoldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/general")
public class ProductSoldController {

    private final ProductSoldService productSoldService;

    public ProductSoldController(ProductSoldService productSoldService) {
        this.productSoldService = productSoldService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getQuantity(@PathVariable Long id) {
        return ResponseEntity.ok(productSoldService.getQuantity(id));
    }

    @GetMapping("/statistics/gender")
    public ResponseEntity<Map<String, Integer>> getSoldQuantityByGenderAllTime() {
        Map<String, Integer> soldQuantity = productSoldService.getSoldQuantityByGenderAllTime();
        return ResponseEntity.ok(soldQuantity);
    }

    @GetMapping("/compare/weekly")
    public ResponseEntity<Double> compareWeeklySoldProducts() {
        double percentageChange = productSoldService.compareWeeklySoldProducts();
        return ResponseEntity.ok(percentageChange);
    }
}
