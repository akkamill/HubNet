package com.example.ecommerceDemo.controllers.blog;

import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.BlogMetricsEntity;
import com.example.ecommerceDemo.services.blog.BlogMetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/metrics")
public class BlogMetricsController {

    private final BlogMetricsService blogMetricsService;

    public BlogMetricsController(BlogMetricsService blogMetricsService) {
        this.blogMetricsService = blogMetricsService;
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<BlogEntity> viewCount(@PathVariable Long blogId) {
        blogMetricsService.viewCount(blogId);
        BlogEntity blog = blogMetricsService.getBlogById(blogId);
        return ResponseEntity.ok(blog);
    }

    @PostMapping("/share/{blogId}")
    public ResponseEntity<Void> shareCount(@PathVariable Long blogId) {
        blogMetricsService.shareCount(blogId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count/{blogId}")
    public ResponseEntity<Map<String, Integer>> getBlogCounts(@PathVariable Long blogId) {
        BlogMetricsEntity metrics = blogMetricsService.getMetricsByBlogId(blogId);
        Map<String, Integer> counts = new HashMap<>();
        counts.put("views", metrics.getViewCount());
        counts.put("shares", metrics.getShareCount());
        return ResponseEntity.ok(counts);
    }
}
