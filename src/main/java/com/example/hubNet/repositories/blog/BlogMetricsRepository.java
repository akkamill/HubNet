package com.example.hubNet.repositories.blog;

import com.example.hubNet.entities.blog.BlogMetricsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMetricsRepository extends JpaRepository<BlogMetricsEntity, Long> {
    BlogMetricsEntity findByBlog_blogId (Long blogId);
}
