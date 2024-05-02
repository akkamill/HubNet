package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.enums.DeliveryType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryDTO {

    private Long deliveryId;
    private DeliveryType deliveryType;
    private BigDecimal deliveryCost;
}
