package com.example.ecommerceDemo.services.user;

import com.example.ecommerceDemo.DTO.user.UserDetailsDTO;
import com.example.ecommerceDemo.entities.user.UserDetails;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.repositories.user.UserDetailsRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.services.mappers.user.page.UserDetailsMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserDetailsRepository userDetailsRepository, UserRepository userRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDetailsDTO createUser(Long userId, UserDetailsDTO userDetailsDTO, MultipartFile profilePhoto) throws IOException {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found " + userId));

        UserDetails userDetails = UserDetailsMappers.toEntity(userDetailsDTO);

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
            String filePath = uploadDir + userDetails.getUserDetailsId() + "_" + profilePhoto.getOriginalFilename();

            // Save the file to the server
            Path profilePhotoPath = Paths.get(filePath);
            Files.write(profilePhotoPath, profilePhoto.getBytes());

            // Set the profile photo path in the user entity
            userDetails.setProfilePhotoPath(filePath);
        }
        userDetails.setUser(userEntity);
        if (userDetails.isEmailVerified()) {
            userDetails.setEmailVerified(true);
        }
        // Save the user entity to the database
        userDetailsRepository.save(userDetails);

        // Map the updated entity back to DTO
        return UserDetailsMappers.toDTO(userDetails);
    }

    @Transactional
    public UserDetailsDTO updateUser(Long detailsId, UserDetails updatedDetails) {
        UserDetails userDetails = userDetailsRepository.findById(detailsId).orElseThrow(()
                -> new RuntimeException("Details not found"));
        userDetails.setAbout(updatedDetails.getAbout());
        userDetails.setPhoneNumber(updatedDetails.getPhoneNumber());
        userDetails.setCountry(updatedDetails.getCountry());
        userDetails.setCity(updatedDetails.getCity());
        userDetails.setState(updatedDetails.getState());
        userDetails.setZipCode(updatedDetails.getZipCode());
        userDetails.setCompany(updatedDetails.getCompany());
        userDetails.setProfilePhoto(updatedDetails.getProfilePhoto());
        userDetails.setUserRole(updatedDetails.getUserRole());

        userDetailsRepository.save(userDetails);

        return UserDetailsMappers.toDTO(userDetails);
    }

    @Transactional
    public void deleteDetails(Long detailsId) {
        userDetailsRepository.deleteById(detailsId);
    }

    @Transactional
    public UserDetailsDTO getUserDetails(Long detailsId) {

        UserDetails userDetails = new UserDetails();

        userDetailsRepository.findById(detailsId).orElseThrow(()
                -> new RuntimeException("Details not found"));

        return UserDetailsMappers.toDTO(userDetails);
    }

    @Transactional
    public List<UserDetailsDTO> getAllDetails() {
        List<UserDetails> entities = userDetailsRepository.findAll();
        List<UserDetailsDTO> dtoList = new ArrayList<>();
        for (UserDetails ud : entities) {
            UserDetailsDTO userDetailsDTO = UserDetailsMappers.toDTO(ud);

            dtoList.add(userDetailsDTO);
        }
        return dtoList;
    }


}


