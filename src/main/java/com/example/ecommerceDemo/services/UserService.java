package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.UserDTO;
import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.repositories.UserRepository;
import com.example.ecommerceDemo.services.mappers.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO, MultipartFile profilePhoto) throws IOException {

        UserEntity userEntity = UserMappers.toEntity(userDTO);

        // Handle profile photo upload
        if (profilePhoto != null && !profilePhoto.isEmpty()) {
            // Define the directory to save profile photos
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommerce\\src\\main\\resources\\profilePhotos\\";

            // Create the directory if it doesn't exist
            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Define the file path
            String filePath = uploadDir + userEntity.getUserId() + "_" + profilePhoto.getOriginalFilename();

            // Save the file to the server
            Path profilePhotoPath = Paths.get(filePath);
            Files.write(profilePhotoPath, profilePhoto.getBytes());

            // Set the profile photo path in the user entity
            userEntity.setProfilePhotoPath(filePath);
        }

        // Save the user entity to the database
        userRepository.save(userEntity);
        System.out.println(userEntity);

        // Map the updated entity back to DTO
        return UserMappers.toDTO(userEntity);
    }


}
