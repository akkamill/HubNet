//package com.example.ecommerceDemo.controllers.user.page;
//
//import com.example.ecommerceDemo.DTO.user.page.FollowingDTO;
//import com.example.ecommerceDemo.services.user.page.FollowingService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/followings")
//public class FollowingController {
//
//    private final FollowingService followingService;
//
//    public FollowingController(FollowingService followingService) {
//        this.followingService = followingService;
//    }
//
//    @PostMapping("/users/{userId}/add/{followingId}")
//    public ResponseEntity<FollowingDTO> addFollowing(@PathVariable Long userId,
//                                                     @PathVariable Long followingId) {
//        FollowingDTO followingDTO = followingService.addFollowing(userId, followingId);
//        return ResponseEntity.ok(followingDTO);
//    }
//
//    @DeleteMapping("/users/{userId}/remove/{followingId}")
//    public ResponseEntity<Void> removeFollowing(@PathVariable Long userId,
//                                                @PathVariable Long followingId) {
//        followingService.removeFollowing(userId, followingId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("getAll/users/{userId}")
//    public ResponseEntity<List<FollowingDTO>> getAllFollowings(@PathVariable Long userId) {
//        List<FollowingDTO> followings = followingService.getFollowings(userId);
//        return ResponseEntity.ok(followings);
//    }
//
//    @GetMapping("/get/users/{userId}/following/{followingId}")
//    public ResponseEntity<FollowingDTO> getFollowing(@PathVariable Long userId,
//                                                     @PathVariable Long followingId) {
//        FollowingDTO followingDTO = followingService.getFollowing(userId, followingId);
//        return ResponseEntity.ok(followingDTO);
//    }
//}
