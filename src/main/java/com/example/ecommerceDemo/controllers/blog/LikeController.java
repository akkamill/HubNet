package com.example.ecommerceDemo.controllers.blog;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.services.blog.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/create-like")
    public ResponseEntity<?> createLike(@RequestParam Long blogId,
                                        @RequestParam Long userId) {
        likeService.createLike(blogId, userId);
        return ResponseEntity.ok("Liked blog " + blogId);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLike(@RequestBody Long likeId) {
        likeService.deleteLike(likeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/like-count/{blogId}")
    public ResponseEntity<Integer> getLikeCount(@PathVariable Long blogId) {
        int likeCount = likeService.getLikeCount(blogId);
        return ResponseEntity.status(HttpStatus.OK).body(likeCount);
    }

    @GetMapping("/get-likers/{blogId}")
    public ResponseEntity<List<UserEntity>> getLikers(@PathVariable Long blogId) {
        List<UserEntity> likers = likeService.getLikers(blogId);
        return new ResponseEntity<>(likers, HttpStatus.OK);
    }

}
