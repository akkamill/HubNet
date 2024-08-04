package com.example.ecommerceDemo.controllers.eCommerce;


import com.example.ecommerceDemo.DTO.eCommerce.ShippingAddressDTO;
import com.example.ecommerceDemo.entities.eCommerce.ShippingAddress;
import com.example.ecommerceDemo.services.eCommerce.ShippingService;
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
