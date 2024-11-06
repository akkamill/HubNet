package com.example.ecommerceDemo.repositories.general;

import com.example.ecommerceDemo.entities.general.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<AuthorsEntity, Long> {

}
