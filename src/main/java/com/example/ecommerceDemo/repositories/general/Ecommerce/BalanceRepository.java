package com.example.ecommerceDemo.repositories.general.Ecommerce;

import com.example.ecommerceDemo.entities.general.Ecommerce.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {

}
