package com.example.ecommerceDemo.controllers.eCommerce;

import com.example.ecommerceDemo.DTO.eCommerce.DiscountCodesDTO;
import com.example.ecommerceDemo.entities.eCommerce.DiscountCodes;
import com.example.ecommerceDemo.services.eCommerce.DiscountService;
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
