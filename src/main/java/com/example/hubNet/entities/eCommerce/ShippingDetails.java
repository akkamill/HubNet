package com.example.hubNet.entities.eCommerce;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShippingDetails {

    private String shippingName;
    private LocalDateTime shippingDate;
    private ShippingAddress shippingAddress;

}
