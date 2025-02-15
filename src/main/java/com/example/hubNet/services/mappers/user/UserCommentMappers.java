package com.example.hubNet.services.mappers.user;

import com.example.hubNet.DTO.user.page.UserCommentDTO;
import com.example.hubNet.entities.user.page.UserCommentEntity;
import com.example.hubNet.services.mappers.user.page.UserPostMappers;
import org.springframework.stereotype.Component;

@Component
public class UserCommentMappers {

    public static UserCommentEntity toEntity(UserCommentDTO userCommentDTO) {
        if (userCommentDTO == null) {
            return null;
        }

        UserCommentEntity userCommentEntity = new UserCommentEntity();
        userCommentEntity.setUserCommentId(userCommentDTO.getUserCommentId());
        userCommentEntity.setCommentText(userCommentDTO.getCommentText());
        userCommentEntity.setCommentImagePath(userCommentDTO.getCommentImagePath());

        userCommentEntity.setCommentPost(UserPostMappers.toEntity(userCommentDTO.getUserPostDTO()));
        userCommentEntity.setUser(UserMappers.toEntity(userCommentDTO.getUserDTO()));

        return userCommentEntity;
    }

    public static UserCommentDTO toDTO(UserCommentEntity userCommentEntity) {
        if (userCommentEntity == null) {
            return null;
        }

        UserCommentDTO userCommentDTO = new UserCommentDTO();
        userCommentDTO.setUserCommentId(userCommentEntity.getUserCommentId());
        userCommentDTO.setCommentText(userCommentEntity.getCommentText());
        userCommentDTO.setCommentImagePath(userCommentEntity.getCommentImagePath());

        userCommentDTO.setUserPostDTO(UserPostMappers.toDTO(userCommentEntity.getCommentPost()));
        userCommentDTO.setUserDTO(UserMappers.toDTO(userCommentEntity.getUser()));

        return userCommentDTO;
    }
}
