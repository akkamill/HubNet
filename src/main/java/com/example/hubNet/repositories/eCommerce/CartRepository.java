package com.example.hubNet.repositories.eCommerce;

import com.example.hubNet.entities.eCommerce.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {



}
