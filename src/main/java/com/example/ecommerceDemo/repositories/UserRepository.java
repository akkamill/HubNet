package com.example.ecommerceDemo.repositories;


import com.example.ecommerceDemo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

    Optional<UserEntity> findByEmailAddress(String emailAddress);



}
