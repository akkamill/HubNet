package com.example.hubNet.repositories.eCommerce;


import com.example.hubNet.entities.eCommerce.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
