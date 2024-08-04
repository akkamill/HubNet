package com.example.ecommerceDemo.repositories.home;

import com.example.ecommerceDemo.entities.home.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, Long> {

}
