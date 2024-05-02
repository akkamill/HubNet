package com.example.ecommerceDemo.entities.shipping;

import com.example.ecommerceDemo.entities.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Cart cart;
    private UserEntity userEntity;
    private ShippingDetails shippingDetails;

}
