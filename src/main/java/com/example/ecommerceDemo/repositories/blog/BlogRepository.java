package com.example.ecommerceDemo.repositories.blog;

import com.example.ecommerceDemo.entities.blog.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    Page<BlogEntity> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<BlogEntity> findAllByOrderByCreatedAtAsc(Pageable pageable);


}
