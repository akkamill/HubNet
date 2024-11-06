package com.example.ecommerceDemo.repositories.general.application;

import com.example.ecommerceDemo.entities.general.application.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

}
