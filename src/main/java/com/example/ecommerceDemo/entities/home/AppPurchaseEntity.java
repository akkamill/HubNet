package com.example.ecommerceDemo.entities.home;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.home.enums.PurchaseType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AppPurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @Enumerated(EnumType.STRING)
    private PurchaseType purchaseType;

    private boolean isYearly;

    @OneToOne
    @JoinColumn(name = "user_purchase")
    private UserEntity userEntity;
}
