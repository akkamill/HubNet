package com.example.ecommerceDemo.entities.general.Ecommerce;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.enums.SellerStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity(name = "bestSeller")
@Data
public class BestSellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bestSellerId;

    private String sellerName;
    private String sellerSurname;
    private String sellerEmailAddress;
    private String sellerCountry;
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private SellerStatus sellerStatus;

    @ManyToOne
    private UserEntity user;

}
