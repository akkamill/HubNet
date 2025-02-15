package com.example.hubNet.entities.eCommerce;

import com.example.hubNet.entities.eCommerce.enums.DeliveryType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "delivery")
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
