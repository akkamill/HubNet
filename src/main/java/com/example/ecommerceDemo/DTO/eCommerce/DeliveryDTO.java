package com.example.ecommerceDemo.DTO.eCommerce;

import com.example.ecommerceDemo.entities.eCommerce.enums.DeliveryType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryDTO {

    private Long deliveryId;
    private DeliveryType deliveryType;
    private BigDecimal deliveryCost;
}
