package com.example.ecommerceDemo.repositories.general.Ecommerce;

import com.example.ecommerceDemo.entities.general.Ecommerce.BestSellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestSellerRepository extends JpaRepository<BestSellerEntity, Long> {

}
