package com.example.ecommerceDemo.repositories.app;

import com.example.ecommerceDemo.entities.app.EmailEntity;
import com.example.ecommerceDemo.entities.app.enums.EmailStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

    List<EmailEntity> findByEmailStatus (EmailStatus status);


}
