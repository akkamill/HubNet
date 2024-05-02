package com.example.ecommerceDemo.entities.shipping;

import com.example.ecommerceDemo.entities.shipping.Cart;
import com.example.ecommerceDemo.enums.DeliveryType;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @Transient
    private BigDecimal deliveryCost;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
