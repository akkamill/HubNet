package com.example.ecommerceDemo.services.blog;

import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.BlogMetricsEntity;
import com.example.ecommerceDemo.repositories.blog.BlogRepository;
import com.example.ecommerceDemo.repositories.blog.BlogMetricsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogMetricsService {

    private final BlogMetricsRepository blogMetricsRepository;
    private final BlogRepository blogRepository;

    public BlogMetricsService(BlogMetricsRepository blogMetricsRepository, BlogRepository blogRepository) {
        this.blogMetricsRepository = blogMetricsRepository;
        this.blogRepository = blogRepository;
    }


    public BlogEntity getBlogById(Long blogId) {
        Optional<BlogEntity> blog = blogRepository.findById(blogId);
        return blog.orElseThrow(() -> new RuntimeException("Blog not found"));

    }


    public BlogMetricsEntity getMetricsByBlogId(Long blogId) {

        BlogMetricsEntity metrics = blogMetricsRepository.findByBlog_blogId(blogId);
        if(metrics == null) {
            BlogEntity blog = getBlogById(blogId);
            metrics.setBlog(blog);
            metrics.setViewCount(0);
            metrics.setShareCount(0);
            blogMetricsRepository.save(metrics);
        }
        return metrics;
    }

    public void viewCount(Long blogId) {
        BlogMetricsEntity viewMetrics = getMetricsByBlogId(blogId);
        viewMetrics.setViewCount(viewMetrics.getViewCount() + 1);
        blogMetricsRepository.save(viewMetrics);
    }

    public void shareCount(Long blogId) {
        BlogMetricsEntity shareMetrics = getMetricsByBlogId(blogId);
        shareMetrics.setShareCount(shareMetrics.getShareCount() + 1);
        blogMetricsRepository.save(shareMetrics);
    }
}
