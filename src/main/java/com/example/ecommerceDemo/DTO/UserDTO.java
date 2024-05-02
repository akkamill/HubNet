package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.app.TaskCommentEntity;
import com.example.ecommerceDemo.services.TaskCommentService;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Transient;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;
    private String name;
    private String lastName;
    private String emailAddress;
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

    private List<LikeDTO> likes;
    private List<TaskCommentDTO> taskComments;
}
