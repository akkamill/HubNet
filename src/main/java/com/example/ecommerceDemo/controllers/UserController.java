package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.UserDTO;
import com.example.ecommerceDemo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@ModelAttribute UserDTO userDTO,
                                              @RequestParam(value = "profilePhoto", required = false)
                                              MultipartFile profilePhoto) {
        try {
            UserDTO createdUser = userService.createUser(userDTO, profilePhoto);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

