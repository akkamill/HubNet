package com.example.ecommerceDemo.services.mappers;

import com.example.ecommerceDemo.DTO.LikeDTO;
import com.example.ecommerceDemo.DTO.UserDTO;
import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMappers {


    public static UserEntity toEntity(UserDTO userDTO) {
//        UserEntity userEntity = new UserEntity();
        UserEntity.Builder builder = new UserEntity.Builder()
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .emailAddress(userDTO.getEmailAddress())
                .phoneNumber(userDTO.getPhoneNumber())
                .country(userDTO.getCountry())
                .city(userDTO.getCity())
                .state(userDTO.getState())
                .zipCode(userDTO.getZipCode())
                .company(userDTO.getCompany())
                .about(userDTO.getAbout())
                .emailVerified(userDTO.isEmailVerified())
                .profilePhoto(userDTO.getProfilePhoto())
                .profilePhotoPath(userDTO.getProfilePhotoPath())
                .profilePublic(userDTO.isProfilePublic())
                .userCreatedAt(userDTO.getUserCreatedAt());
//                .likes(userDTO.getLikes().stream()
//                        .map(likeDTO -> new LikeEntity.Builder().likeId(likeDTO.getLikeId()).build())
//                        .collect(Collectors.toList()))
//                .build();

        if (userDTO.getLikes() != null) {
            builder.likes(userDTO.getLikes().stream()
                    .map(likeDTO -> new LikeEntity.Builder().likeId(likeDTO.getLikeId()).build())
                    .collect(Collectors.toList()));
        }

//        userEntity.setUserId(userDTO.getUserId());
//        userEntity.setName(userDTO.getName());
//        userEntity.setLastName(userDTO.getLastName());
//        userEntity.setEmailAddress(userDTO.getEmailAddress());
//        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
//        userEntity.setCountry(userDTO.getCountry());
//        userEntity.setCity(userDTO.getCity());
//        userEntity.setState(userDTO.getState());
//        userEntity.setZipCode(userDTO.getZipCode());
//        userEntity.setCompany(userDTO.getCompany());
//        userEntity.setAbout(userDTO.getAbout());
//        userEntity.setProfilePhotoPath(userDTO.getProfilePhotoPath());
//        userEntity.setEmailVerified(userDTO.isEmailVerified());
//        userEntity.setProfilePublic(userDTO.isProfilePublic());
//        userEntity.setUserCreatedAt(userDTO.getUserCreatedAt());
//        if (userDTO.getLikes() != null) {
//            List<LikeEntity> likeEntities = userDTO.getLikes().stream()
//                    .map(likeDTO -> {
//                        LikeEntity likeEntity = new LikeEntity();
//                        likeEntity.setLikeId(likeDTO.getLikeId());
//                        return likeEntity;
//                    })
//                    .collect(Collectors.toList());
//            userEntity.setLikes(likeEntities);
//        }
        return builder.build();

    }

    public static UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setName(userEntity.getName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setEmailAddress(userEntity.getEmailAddress());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        userDTO.setCountry(userEntity.getCountry());
        userDTO.setCity(userEntity.getCity());
        userDTO.setState(userEntity.getState());
        userDTO.setZipCode(userEntity.getZipCode());
        userDTO.setCompany(userEntity.getCompany());
        userDTO.setAbout(userEntity.getAbout());
        userDTO.setProfilePhotoPath(userEntity.getProfilePhotoPath());
        userDTO.setEmailVerified(userEntity.isEmailVerified());
        userDTO.setProfilePublic(userEntity.isProfilePublic());
        userDTO.setUserCreatedAt(userEntity.getUserCreatedAt());

        if (userEntity.getLikes() != null) {
            List<LikeDTO> likeDTOs = userEntity.getLikes().stream()
                    .map(likeEntity -> {
                        LikeDTO likeDTO = new LikeDTO();
                        likeDTO.setLikeId(likeEntity.getLikeId());
                        return likeDTO;
                    })
                    .collect(Collectors.toList());
            userDTO.setLikes(likeDTOs);
        }

        return userDTO;
    }

}
