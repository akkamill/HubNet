package com.example.ecommerceDemo.entities.shipping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartItem> cartItems;

    @ManyToOne
    private DiscountCodes appliedDiscountCode;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private DeliveryEntity deliveryEntity;

    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discountPrice;

}
