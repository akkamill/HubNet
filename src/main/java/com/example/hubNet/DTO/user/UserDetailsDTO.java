package com.example.hubNet.DTO.user;

import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDetailsDTO {

    private Long userDetailsId;
    private String phoneNumber;
    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String company;
    private String about;

    private boolean emailVerified;
    private boolean profilePublic;

    private LocalDateTime userCreatedAt;

    @Transient
    private MultipartFile profilePhoto;
    private String profilePhotoPath;

    private UserDTO userDTO;
    private List<SocialMediaLinksDTO> socialMediaLinksDTOS;

}
