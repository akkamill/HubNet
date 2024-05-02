package com.example.ecommerceDemo.entities;

import com.example.ecommerceDemo.entities.app.ChatEntity;
import com.example.ecommerceDemo.entities.app.EmailEntity;
import com.example.ecommerceDemo.entities.app.TaskCommentEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import com.example.ecommerceDemo.entities.shipping.ShippingAddress;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private MultipartFile profilePhoto;
    private String profilePhotoPath;

    private boolean emailVerified;
    private boolean profilePublic;

    @CreationTimestamp
    private LocalDateTime userCreatedAt;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<ShippingAddress> shippingAddresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @OneToMany(mappedBy = "taskCommentUser", cascade = CascadeType.ALL)
    private List<TaskCommentEntity> taskComments;

    @OneToMany(mappedBy = "senderEmail", cascade = CascadeType.ALL)
    private List<EmailEntity> senderEmail;

    @OneToMany(mappedBy = "recipientEmail", cascade = CascadeType.ALL)
    private List<EmailEntity> recipientEmail;

    @OneToMany(mappedBy = "senderChat", cascade = CascadeType.ALL)
    private List<ChatEntity> senderChat;


    private UserEntity(Builder builder) {
        setUserId(builder.userId);
        setName(builder.name);
        setLastName(builder.lastName);
        setEmailAddress(builder.emailAddress);
        setPhoneNumber(builder.phoneNumber);
        setCountry(builder.country);
        setCity(builder.city);
        setState(builder.state);
        setZipCode(builder.zipCode);
        setCompany(builder.company);
        setAbout(builder.about);
        setProfilePhoto(builder.profilePhoto);
        setProfilePhotoPath(builder.profilePhotoPath);
        setEmailVerified(builder.emailVerified);
        setProfilePublic(builder.profilePublic);
        setUserCreatedAt(builder.userCreatedAt);
        setLikes(builder.likes);
        setTaskComments(builder.taskComments);
    }


    public static final class Builder {
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
        private MultipartFile profilePhoto;
        private String profilePhotoPath;
        private boolean emailVerified;
        private boolean profilePublic;
        private LocalDateTime userCreatedAt;
        private List<LikeEntity> likes;
        private List<TaskCommentEntity> taskComments;


        public Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userId(Long val) {
            userId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder emailAddress(String val) {
            emailAddress = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder state(String val) {
            state = val;
            return this;
        }

        public Builder zipCode(String val) {
            zipCode = val;
            return this;
        }

        public Builder company(String val) {
            company = val;
            return this;
        }

        public Builder about(String val) {
            about = val;
            return this;
        }

        public Builder profilePhoto(MultipartFile val) {
            profilePhoto = val;
            return this;
        }

        public Builder profilePhotoPath(String val) {
            profilePhotoPath = val;
            return this;
        }

        public Builder emailVerified(boolean val) {
            emailVerified = val;
            return this;
        }

        public Builder profilePublic(boolean val) {
            profilePublic = val;
            return this;
        }

        public Builder userCreatedAt(LocalDateTime val) {
            userCreatedAt = val;
            return this;
        }

        public Builder likes(List<LikeEntity> val) {
            likes = val;
            return this;
        }

        public Builder taskComments(List<TaskCommentEntity> val) {
            taskComments = val;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
