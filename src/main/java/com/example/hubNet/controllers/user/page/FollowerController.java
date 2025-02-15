//package com.example.ecommerceDemo.controllers.user.page;
//
//import com.example.ecommerceDemo.DTO.user.page.FollowerDTO;
//import com.example.ecommerceDemo.services.user.page.FollowerService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/followers")
//public class FollowerController {
//
//    private final FollowerService followerService;
//
//    public FollowerController(FollowerService followerService) {
//        this.followerService = followerService;
//    }
//
//    @PostMapping("/users/{userId}/add/{followerId}")
//    public ResponseEntity<FollowerDTO> addFollower(@PathVariable Long userId,
//                                                   @PathVariable Long followerId) {
//        FollowerDTO followerDTO = followerService.addFollower(userId, followerId);
//        return ResponseEntity.ok(followerDTO);
//    }
//
//    @DeleteMapping("/users/{userId}/remove/{followerId}")
//    public ResponseEntity<Void> removeFollower(@PathVariable Long userId,
//                                               @PathVariable Long followerId) {
//        followerService.removeFollower(userId, followerId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/getAll/users/{userId}")
//    public ResponseEntity<List<FollowerDTO>> getAllFollowers(@PathVariable Long userId) {
//        List<FollowerDTO> followers = followerService.getAllFollowers(userId);
//        return ResponseEntity.ok(followers);
//    }
//
//    @GetMapping("/get/users/{userId}/follower/{followerId}")
//    public ResponseEntity<FollowerDTO> getFollower(@PathVariable Long userId,
//                                                   @PathVariable Long followerId) {
//        FollowerDTO followerDTO = followerService.getFollower(userId, followerId);
//        return ResponseEntity.ok(followerDTO);
//    }
//}
