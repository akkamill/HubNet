package com.example.ecommerceDemo.repositories.eCommerce;

import com.example.ecommerceDemo.entities.eCommerce.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingAddress, Long> {

}
