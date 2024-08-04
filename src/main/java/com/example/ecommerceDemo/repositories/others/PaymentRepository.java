package com.example.ecommerceDemo.repositories.others;

import com.example.ecommerceDemo.entities.others.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
