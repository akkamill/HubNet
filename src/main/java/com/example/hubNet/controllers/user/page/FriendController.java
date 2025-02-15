//package com.example.ecommerceDemo.controllers.user.page;
//
//import com.example.ecommerceDemo.DTO.user.page.FriendDTO;
//import com.example.ecommerceDemo.services.user.page.FriendService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/friends")
//public class FriendController {
//
//    private final FriendService friendService;
//
//    public FriendController(FriendService friendService) {
//        this.friendService = friendService;
//    }
//
//    @PostMapping("/add/users/{userId}/add/{friendId}")
//    public ResponseEntity<FriendDTO> addFriend(@PathVariable Long userId, @PathVariable Long friendId) {
//        FriendDTO friendDTO = friendService.addFriend(userId, friendId);
//        return ResponseEntity.ok(friendDTO);
//    }
//
//    @DeleteMapping("/users/{userId}/remove/{friendId}")
//    public ResponseEntity<Void> removeFriend(@PathVariable Long userId, @PathVariable Long friendId) {
//        friendService.removeFriend(userId, friendId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/getAll/{userId}")
//    public ResponseEntity<List<FriendDTO>> getAllFriends(@PathVariable Long userId) {
//        List<FriendDTO> friends = friendService.getAllFriends(userId);
//        return ResponseEntity.ok(friends);
//    }
//
//    @GetMapping("/get/users/{userId}/friend/{friendId}")
//    public ResponseEntity<FriendDTO> getFriend(@PathVariable Long userId, @PathVariable Long friendId) {
//        FriendDTO friendDTO = friendService.getFriend(userId, friendId);
//        return ResponseEntity.ok(friendDTO);
//    }
//}
