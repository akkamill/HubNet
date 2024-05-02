package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.app.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
