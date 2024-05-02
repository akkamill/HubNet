package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.enums.DeliveryType;
import com.example.ecommerceDemo.services.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PutMapping("/add/{cartId}")
    public ResponseEntity<?> deliveryPrice(@PathVariable Long cartId,
                                           @RequestParam("deliveryType")DeliveryType deliveryType) {
        deliveryService.deliveryPrice(cartId, deliveryType);
        return ResponseEntity.ok("Added successfully");
    }
}
