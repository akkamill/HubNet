package com.example.hubNet.entities.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailsId;

    private String phoneNumber;
    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String company;
    private String about;
    private String userRole;


    @Transient
    private MultipartFile profilePhoto;
    private String profilePhotoPath;

    private boolean emailVerified;
    private boolean profilePublic;

    @CreationTimestamp
    private LocalDateTime userCreatedAt;

    @OneToOne
    @JoinColumn(name = "user_details")
    private UserEntity user;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<SocialMediaLinks> socialMediaLinks;


}
