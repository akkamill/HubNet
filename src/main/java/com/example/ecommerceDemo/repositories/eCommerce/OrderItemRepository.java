package com.example.ecommerceDemo.repositories.eCommerce;

import com.example.ecommerceDemo.entities.eCommerce.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
