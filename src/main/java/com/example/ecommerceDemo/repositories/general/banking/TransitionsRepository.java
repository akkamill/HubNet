package com.example.ecommerceDemo.repositories.general.banking;

import com.example.ecommerceDemo.entities.general.banking.TransitionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitionsRepository extends JpaRepository<TransitionsEntity, Long> {

}