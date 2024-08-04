package com.example.ecommerceDemo.repositories.app;


import com.example.ecommerceDemo.entities.app.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {

}
