package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.ReviewDTO;
import com.example.ecommerceDemo.entities.ReviewEntity;
import com.example.ecommerceDemo.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<?> createReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        reviewService.createReview(id, reviewDTO);
        return ResponseEntity.ok("Created successfully");
    }
}
