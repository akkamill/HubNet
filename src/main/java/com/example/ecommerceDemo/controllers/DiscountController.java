package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.DiscountCodesDTO;
import com.example.ecommerceDemo.entities.shipping.DiscountCodes;
import com.example.ecommerceDemo.services.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/create-discount-code")
    public ResponseEntity<DiscountCodes> createDiscountCode(@RequestBody DiscountCodesDTO discountCodesDTO) {
        return ResponseEntity.ok(discountService.createDiscountCode(discountCodesDTO));
    }
}
