package com.example.hubNet.DTO.eCommerce;

import com.example.hubNet.entities.eCommerce.enums.DeliveryType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryDTO {

    private Long deliveryId;
    private DeliveryType deliveryType;
    private BigDecimal deliveryCost;
}
