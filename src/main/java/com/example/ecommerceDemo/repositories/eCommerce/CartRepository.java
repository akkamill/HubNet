package com.example.ecommerceDemo.repositories.eCommerce;

import com.example.ecommerceDemo.entities.eCommerce.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {



}
