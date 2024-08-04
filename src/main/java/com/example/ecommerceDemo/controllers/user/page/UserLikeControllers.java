package com.example.ecommerceDemo.controllers.user.page;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.services.user.page.UserLikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-likes")
public class UserLikeControllers {

    private final UserLikeService userLikeService;

    public UserLikeControllers(UserLikeService userLikeService) {
        this.userLikeService = userLikeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createLike(@RequestParam Long userPostId,
                                           @RequestParam Long userId) {
        try {
            userLikeService.createLike(userPostId, userId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getLikers/{postId}")
    public ResponseEntity<List<UserEntity>> getLikers(@PathVariable Long postId) {
        try {
            List<UserEntity> likers = userLikeService.getLikers(postId);
            return new ResponseEntity<>(likers, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Integer> getLikeCount(@PathVariable Long postId) {
        try {
            int likeCount = userLikeService.getLikeCount(postId);
            return new ResponseEntity<>(likeCount, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long likeId) {
        try {
            userLikeService.deleteLike(likeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
