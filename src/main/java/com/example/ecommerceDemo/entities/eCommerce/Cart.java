package com.example.ecommerceDemo.entities.eCommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartItem> cartItems;

    @ManyToOne
    @JoinColumn(name = "discount_code")
    private DiscountCodes appliedDiscountCode;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private DeliveryEntity deliveryEntity;

    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;

}
