package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.shipping.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {



}
