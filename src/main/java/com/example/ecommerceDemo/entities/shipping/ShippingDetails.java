package com.example.ecommerceDemo.entities.shipping;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ShippingDetails {

    private String shippingName;
    private LocalDateTime shippingDate;
    private ShippingAddress shippingAddress;

}
