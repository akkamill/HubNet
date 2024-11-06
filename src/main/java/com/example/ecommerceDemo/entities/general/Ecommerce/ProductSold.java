package com.example.ecommerceDemo.entities.general.Ecommerce;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "product_quantity")
@Data
public class ProductSold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSoldId;

    private int productSoldQuantity;
    private String saleByGender;

    @CreationTimestamp
    private LocalDateTime saleDate;

    @ManyToOne
    private UserEntity user;
}
