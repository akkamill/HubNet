package com.example.hubNet.repositories.general.Ecommerce;

import com.example.hubNet.entities.general.Ecommerce.BestSellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestSellerRepository extends JpaRepository<BestSellerEntity, Long> {

}
