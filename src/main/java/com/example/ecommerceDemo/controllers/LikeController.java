package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.services.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/create-like/{blogId}")
    public ResponseEntity<?> createLike(@PathVariable Long blogId,
                                        @RequestParam Long userId) {
        likeService.createLike(blogId, userId);
        return ResponseEntity.ok("Liked blog post" + blogId);
    }

}
