package com.example.hubNet.repositories.eCommerce;

import com.example.hubNet.entities.eCommerce.DeliveryEntity;
import com.example.hubNet.entities.eCommerce.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

    Optional<DeliveryEntity> findByCart(Cart cart);

}
