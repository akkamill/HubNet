package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.blog.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}
