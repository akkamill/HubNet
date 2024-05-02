package com.example.ecommerceDemo.controllers;


import com.example.ecommerceDemo.DTO.ShippingAddressDTO;
import com.example.ecommerceDemo.entities.shipping.ShippingAddress;
import com.example.ecommerceDemo.services.ShippingService;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping("/create")
    public ResponseEntity<ShippingAddress> createShipping(@RequestBody ShippingAddressDTO shippingAddressDTO) {
        return ResponseEntity.ok(shippingService.createAddress(shippingAddressDTO));
    }
}
