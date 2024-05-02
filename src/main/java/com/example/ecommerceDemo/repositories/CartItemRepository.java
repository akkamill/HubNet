package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.shipping.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
