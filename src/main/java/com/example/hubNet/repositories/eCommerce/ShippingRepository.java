package com.example.hubNet.repositories.eCommerce;

import com.example.hubNet.entities.eCommerce.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingAddress, Long> {

}
