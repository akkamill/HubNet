package com.example.ecommerceDemo.controllers.user;

import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import com.example.ecommerceDemo.DTO.user.UserDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3005")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserEntity updatedUser) {
        UserDTO user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        UserDTO user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/change-password/{userId}")
    public ResponseEntity<Void> changePassword(@PathVariable Long userId,
                                               @RequestBody String oldPassword,
                                               @RequestBody String newPassword,
                                               @RequestBody String confirmNewPassword) {
        userService.changePassword(userId, oldPassword, newPassword, confirmNewPassword);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/ban/{bannedUserId}")
    public ResponseEntity<Void> banUser(@PathVariable Long userId,
                                        @PathVariable Long bannedUserId) {
        userService.banUser(userId, bannedUserId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/premium/{userId}")
    public ResponseEntity<?> premiumAccount(@PathVariable Long userId,
                                            @RequestBody ProcessPaymentRequest paymentRequest) {
        userService.premiumAccount(userId, paymentRequest);
        return ResponseEntity.ok("Payment Successfully");
    }


}

