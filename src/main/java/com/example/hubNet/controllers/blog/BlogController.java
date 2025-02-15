package com.example.hubNet.controllers.blog;

import com.example.hubNet.DTO.blog.BlogDTO;
import com.example.hubNet.entities.blog.BlogEntity;
import com.example.hubNet.services.blog.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(value = "/create-blog/{userId}")
    public ResponseEntity<?> createBlog(@PathVariable Long userId,
//                                        @ModelAttribute BlogDTO blogDTO,
                                        @RequestParam BlogDTO blogDTO,
//                                        @RequestPart(value = "blogImage",required = false)
                                        @RequestParam(value = "blogImage", required = false) MultipartFile blogImage ) {
        System.out.println("Received blogDTO: " + blogDTO);
        if (blogImage != null) {
            System.out.println("Received Image: " + blogImage.getOriginalFilename());
        }
        try {
            BlogDTO createdBlog = blogService.createBlog(userId, blogDTO, blogImage);
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

    @GetMapping("/get-a-blog")
    public BlogDTO getBlogById(@RequestParam Long blogId) {
        return ResponseEntity.ok(blogService.getBlogById(blogId)).getBody();
    }

    @DeleteMapping("/delete-blog/{blogId}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
        return ResponseEntity.ok("Blog has been deleted " + blogId);

    }

    @PutMapping("/update-blog")
    public ResponseEntity<?> updateBlog(Long blogId, BlogDTO blogDTO) {
        blogService.updateBlog(blogId, blogDTO);
        return ResponseEntity.ok("Blog has been updated: " + blogDTO);
    }

    @PostMapping("/enable-comment/{blogId}")
    public ResponseEntity<?> isEnableComment(@PathVariable Long blogId,
                                             @RequestBody boolean isEnable) {
        blogService.isEnableComment(blogId, isEnable);
        return ResponseEntity.ok("Blog comments disable");
    }

    @GetMapping("/latest")
    public ResponseEntity<Page<BlogEntity>> getLatestBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<BlogEntity> latestBlogs = blogService.getLatestBlogs(page, size);
        return ResponseEntity.ok(latestBlogs);
    }

    @GetMapping("/newest")
    public ResponseEntity<Page<BlogEntity>> getNewestBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<BlogEntity> newestBlogs = blogService.getNewestBlogs(page, size);
        return ResponseEntity.ok(newestBlogs);
    }

}
