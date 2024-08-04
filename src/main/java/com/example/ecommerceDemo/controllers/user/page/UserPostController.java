package com.example.ecommerceDemo.controllers.user.page;

import com.example.ecommerceDemo.DTO.user.page.UserPostDTO;
import com.example.ecommerceDemo.services.user.page.UserPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user-posts")
public class UserPostController {

    private final UserPostService userPostService;

    public UserPostController(UserPostService userPostService) {
        this.userPostService = userPostService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<UserPostDTO> createPost(@PathVariable Long userId,
                                                  @RequestParam String postBody,
                                                  @RequestParam(value = "postImage", required = false) MultipartFile postImage) throws IOException {
        UserPostDTO userPostDTO = new UserPostDTO();
        userPostDTO.setPostBody(postBody);

        UserPostDTO createdPost = userPostService.createPost(userId, userPostDTO, postImage);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<UserPostDTO> updatePost(@PathVariable Long postId,
                                                  @RequestBody UserPostDTO userPostDTO) {
        UserPostDTO updatedPost = userPostService.updateUserPost(postId, userPostDTO);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        userPostService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserPostDTO>> getAllPosts() {
        List<UserPostDTO> posts = userPostService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("get/{postId}")
    public ResponseEntity<UserPostDTO> getPost(@PathVariable Long postId) {
        UserPostDTO post = userPostService.getPost(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
