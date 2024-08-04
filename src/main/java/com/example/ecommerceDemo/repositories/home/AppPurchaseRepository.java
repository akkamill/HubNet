package com.example.ecommerceDemo.repositories.home;

import com.example.ecommerceDemo.entities.home.AppPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPurchaseRepository extends JpaRepository<AppPurchaseEntity, Long> {

}
