package com.example.ecommerceDemo.repositories.general.banking;

import com.example.ecommerceDemo.entities.general.Ecommerce.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceReposiotry extends JpaRepository<BalanceEntity, Long> {

}