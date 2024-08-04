package com.example.ecommerceDemo.services.mappers.user;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.services.mappers.app.TaskCommentMappers;
import com.example.ecommerceDemo.services.mappers.blog.LikeMappers;
import org.springframework.stereotype.Component;

@Component
public class UserMappers {

    public static UserEntity toEntity(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userDTO.getUserId());
        userEntity.setName(userDTO.getName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setEmailAddress(userDTO.getEmailAddress());

        userEntity.setUserCreatedAt(userDTO.getUserCreatedAt());

//        userEntity.setUserDetails(UserDetailsMappers.toEntity(userDTO.getUserDetailsDTO()));

//        ----------------------------------------------------------------------------------------------------------- //

        userEntity.setLikes(LikeMappers.toEntityList(userDTO.getLikes()));
        userEntity.setTaskComments(TaskCommentMappers.toEntityList(userDTO.getTaskComments()));

        return userEntity;
    }

    public static UserDTO toDTO(UserEntity userEntity) {

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(userEntity.getUserId());
        userDTO.setName(userEntity.getName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setEmailAddress(userEntity.getEmailAddress());

        userDTO.setUserCreatedAt(userEntity.getUserCreatedAt());

//        userDTO.setUserDetailsDTO(UserDetailsMappers.toDTO(userEntity.getUserDetails()));

//        ---------------------------------------------------------------------------------------------------------- //

        userDTO.setLikes(LikeMappers.toDTOList(userEntity.getLikes()));
        userDTO.setTaskComments(TaskCommentMappers.toDTOList(userEntity.getTaskComments()));

        return userDTO;
    }

}


//
//    public static UserEntity toEntity(UserDTO userDTO) {
////        UserEntity userEntity = new UserEntity();
//        UserEntity.Builder builder = new UserEntity.Builder()
//                .userId(userDTO.getUserId())
//                .name(userDTO.getName())
//                .lastName(userDTO.getLastName())
//                .emailAddress(userDTO.getEmailAddress())
//                .phoneNumber(userDTO.getPhoneNumber())
//                .country(userDTO.getCountry())
//                .city(userDTO.getCity())
//                .state(userDTO.getState())
//                .zipCode(userDTO.getZipCode())
//                .company(userDTO.getCompany())
//                .about(userDTO.getAbout())
//                .emailVerified(userDTO.isEmailVerified())
//                .profilePhoto(userDTO.getProfilePhoto())
//                .profilePhotoPath(userDTO.getProfilePhotoPath())
//                .profilePublic(userDTO.isProfilePublic())
//                .userCreatedAt(userDTO.getUserCreatedAt());
////                .likes(userDTO.getLikes().stream()
////                        .map(likeDTO -> new LikeEntity.Builder().likeId(likeDTO.getLikeId()).build())
////                        .collect(Collectors.toList()))
////                .build();
//
//        if (userDTO.getLikes() != null) {
//            builder.likes(userDTO.getLikes().stream()
//                    .map(likeDTO -> new LikeEntity.Builder().likeId(likeDTO.getLikeId()).build())
//                    .collect(Collectors.toList()));
//        }
//
////        userEntity.setUserId(userDTO.getUserId());
////        userEntity.setName(userDTO.getName());
////        userEntity.setLastName(userDTO.getLastName());
////        userEntity.setEmailAddress(userDTO.getEmailAddress());
////        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
////        userEntity.setCountry(userDTO.getCountry());
////        userEntity.setCity(userDTO.getCity());
////        userEntity.setState(userDTO.getState());
////        userEntity.setZipCode(userDTO.getZipCode());
////        userEntity.setCompany(userDTO.getCompany());
////        userEntity.setAbout(userDTO.getAbout());
////        userEntity.setProfilePhotoPath(userDTO.getProfilePhotoPath());
////        userEntity.setEmailVerified(userDTO.isEmailVerified());
////        userEntity.setProfilePublic(userDTO.isProfilePublic());
////        userEntity.setUserCreatedAt(userDTO.getUserCreatedAt());
////        if (userDTO.getLikes() != null) {
////            List<LikeEntity> likeEntities = userDTO.getLikes().stream()
////                    .map(likeDTO -> {
////                        LikeEntity likeEntity = new LikeEntity();
////                        likeEntity.setLikeId(likeDTO.getLikeId());
////                        return likeEntity;
////                    })
////                    .collect(Collectors.toList());
////            userEntity.setLikes(likeEntities);
////        }
//        return builder.build();
//
//    }
//
//    public static UserDTO toDTO(UserEntity userEntity) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(userEntity.getUserId());
//        userDTO.setName(userEntity.getName());
//        userDTO.setLastName(userEntity.getLastName());
//        userDTO.setEmailAddress(userEntity.getEmailAddress());
//        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
//        userDTO.setCountry(userEntity.getCountry());
//        userDTO.setCity(userEntity.getCity());
//        userDTO.setState(userEntity.getState());
//        userDTO.setZipCode(userEntity.getZipCode());
//        userDTO.setCompany(userEntity.getCompany());
//        userDTO.setAbout(userEntity.getAbout());
//        userDTO.setProfilePhotoPath(userEntity.getProfilePhotoPath());
//        userDTO.setEmailVerified(userEntity.isEmailVerified());
//        userDTO.setProfilePublic(userEntity.isProfilePublic());
//        userDTO.setUserCreatedAt(userEntity.getUserCreatedAt());
//
//        if (userEntity.getLikes() != null) {
//            List<LikeDTO> likeDTOs = userEntity.getLikes().stream()
//                    .map(likeEntity -> {
//                        LikeDTO likeDTO = new LikeDTO();
//                        likeDTO.setLikeId(likeEntity.getLikeId());
//                        return likeDTO;
//                    })
//                    .collect(Collectors.toList());
//            userDTO.setLikes(likeDTOs);
//        }
//
//        return userDTO;
//    }
//
//}
