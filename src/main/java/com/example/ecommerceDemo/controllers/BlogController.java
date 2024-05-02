package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.BlogDTO;
import com.example.ecommerceDemo.services.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/create-blog")
    public ResponseEntity<?> createBlog(@ModelAttribute BlogDTO blogDTO,
                                        @RequestParam(value = "blogImage", required = false)
                                        MultipartFile blogImage) {
        try {
            BlogDTO createdBlog = blogService.createBlog(blogDTO, blogImage);
            return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-blogs")
    public ResponseEntity<?> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

}
