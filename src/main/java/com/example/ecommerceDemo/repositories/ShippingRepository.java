package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.shipping.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingAddress, Long> {

}
