package com.example.hubNet.controllers.eCommerce;

import com.example.hubNet.entities.eCommerce.enums.DeliveryType;
import com.example.hubNet.services.eCommerce.DeliveryService;
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
