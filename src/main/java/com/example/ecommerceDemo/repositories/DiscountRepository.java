package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.shipping.DiscountCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountCodes, Long> {

    DiscountCodes findByDiscountCode(String enteredCode);


}
