package com.example.hubNet.controllers.user;

import com.example.hubNet.DTO.user.UserDetailsDTO;
import com.example.hubNet.entities.user.UserDetails;
import com.example.hubNet.services.user.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user-details")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<UserDetailsDTO> createUser(@PathVariable Long userId,
                                                     @ModelAttribute UserDetailsDTO userDetailsDTO,
                                                     @RequestParam(value = "profilePhoto", required = false)
                                                     MultipartFile profilePhoto) {
        try {
            UserDetailsDTO createdUser = userDetailsService.createUser(userId, userDetailsDTO, profilePhoto);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDetailsDTO> updateUser(@PathVariable("id") Long id,
                                                     @RequestBody UserDetails updatedDetails) {
        try {
            UserDetailsDTO updatedUserDetails = userDetailsService.updateUser(id, updatedDetails);
            return ResponseEntity.ok(updatedUserDetails);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        try {
            userDetailsService.deleteDetails(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable("id") Long id) {
        try {
            UserDetailsDTO userDetails = userDetailsService.getUserDetails(id);
            return ResponseEntity.ok(userDetails);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDetailsDTO>> getAllDetails() {
        List<UserDetailsDTO> userDetailsList = userDetailsService.getAllDetails();
        return ResponseEntity.ok(userDetailsList);
    }


}
