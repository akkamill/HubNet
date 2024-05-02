package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.app.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {


}
