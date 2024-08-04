package com.example.ecommerceDemo.services.mappers.user.page;

import com.example.ecommerceDemo.DTO.user.page.UserLikeDTO;
import com.example.ecommerceDemo.entities.user.page.UserLikeEntity;
import com.example.ecommerceDemo.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class UserLikeMappers {

    public static UserLikeEntity toEntity(UserLikeDTO userLikeDTO) {
        if (userLikeDTO == null) {
            return null;
        }

        UserLikeEntity userLikeEntity = new UserLikeEntity();
        userLikeEntity.setUserLikeId(userLikeDTO.getUserLikeId());

        userLikeEntity.setUser(UserMappers.toEntity(userLikeDTO.getUserDTO()));
        userLikeEntity.setUserPost(UserPostMappers.toEntity(userLikeDTO.getUserPostDTO()));

        return userLikeEntity;
    }

    public static UserLikeDTO toDTO(UserLikeEntity userLikeEntity) {
        if (userLikeEntity == null) {
            return null;
        }

        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setUserLikeId(userLikeEntity.getUserLikeId());

        userLikeDTO.setUserDTO(UserMappers.toDTO(userLikeEntity.getUser()));
        userLikeDTO.setUserPostDTO(UserPostMappers.toDTO(userLikeEntity.getUserPost()));

        return userLikeDTO;
    }
}
