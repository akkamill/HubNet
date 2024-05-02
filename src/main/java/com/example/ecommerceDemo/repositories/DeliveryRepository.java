package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.shipping.DeliveryEntity;
import com.example.ecommerceDemo.entities.shipping.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

    Optional<DeliveryEntity> findByCart(Cart cart);

}
