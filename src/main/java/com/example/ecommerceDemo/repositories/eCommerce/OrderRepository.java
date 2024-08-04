package com.example.ecommerceDemo.repositories.eCommerce;

import com.example.ecommerceDemo.entities.eCommerce.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
