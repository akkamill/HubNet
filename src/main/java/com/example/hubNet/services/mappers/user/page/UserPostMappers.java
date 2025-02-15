package com.example.hubNet.services.mappers.user.page;

import com.example.hubNet.DTO.user.page.UserPostDTO;
import com.example.hubNet.entities.user.page.UserPostEntity;
import com.example.hubNet.services.mappers.user.UserCommentMappers;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserPostMappers {

    public static UserPostEntity toEntity(UserPostDTO userPostDTO) {
        if (userPostDTO == null) {
            return null;
        }

        UserPostEntity userPostEntity = new UserPostEntity();
        userPostEntity.setUserPostId(userPostDTO.getUserPostId());
        userPostEntity.setPostBody(userPostDTO.getPostBody());
        userPostEntity.setPostImagePath(userPostDTO.getPostImagePath());
        userPostEntity.setCreatedAt(userPostDTO.getCreatedAt());

        userPostEntity.setUser(UserMappers.toEntity(userPostDTO.getUserDTO()));

        if (userPostDTO.getUserLikes() != null) {
            userPostEntity.setUserLike(userPostDTO.getUserLikes().stream()
                    .map(UserLikeMappers::toEntity)
                    .collect(Collectors.toList()));
        }

        if (userPostDTO.getUserComments() != null) {
            userPostEntity.setUserComment(userPostDTO.getUserComments().stream()
                    .map(UserCommentMappers::toEntity)
                    .collect(Collectors.toList()));
        }

        return userPostEntity;
    }

    public static UserPostDTO toDTO(UserPostEntity userPostEntity) {
        if (userPostEntity == null) {
            return null;
        }

        UserPostDTO userPostDTO = new UserPostDTO();
        userPostDTO.setUserPostId(userPostEntity.getUserPostId());
        userPostDTO.setPostBody(userPostEntity.getPostBody());
        userPostDTO.setPostImagePath(userPostEntity.getPostImagePath());
        userPostDTO.setCreatedAt(userPostEntity.getCreatedAt());

        userPostDTO.setUserDTO(UserMappers.toDTO(userPostEntity.getUser()));

        if (userPostEntity.getUserLike() != null) {
            userPostDTO.setUserLikes(userPostEntity.getUserLike().stream()
                    .map(UserLikeMappers::toDTO)
                    .collect(Collectors.toList()));
        }

        if (userPostEntity.getUserComment() != null) {
            userPostDTO.setUserComments(userPostEntity.getUserComment().stream()
                    .map(UserCommentMappers::toDTO)
                    .collect(Collectors.toList()));
        }

        return userPostDTO;
    }
}

