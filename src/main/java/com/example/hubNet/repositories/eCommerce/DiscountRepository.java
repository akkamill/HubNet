package com.example.hubNet.repositories.eCommerce;

import com.example.hubNet.entities.eCommerce.DiscountCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountCodes, Long> {

    DiscountCodes findByDiscountCode(String enteredCode);


}
