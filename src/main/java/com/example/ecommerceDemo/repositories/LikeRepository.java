package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.blog.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

}
