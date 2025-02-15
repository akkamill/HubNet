package com.example.hubNet.services.mappers.blog;

import com.example.hubNet.DTO.blog.CommentDTO;
import com.example.hubNet.entities.blog.CommentEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class CommentMappers {


    public static CommentEntity toEntity(CommentDTO commentDTO) {

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setCommentId(commentDTO.getCommentId());
        commentEntity.setCommentText(commentDTO.getCommentText());
        commentEntity.setCommentName(commentDTO.getCommentName());
        commentEntity.setCommentEmail(commentDTO.getCommentEmail());
        commentEntity.setCommentCreatedAt(commentDTO.getCommentCreatedAt());

        commentEntity.setUserEntity(UserMappers.toEntity(commentDTO.getUserDTO()));

        return commentEntity;
    }

    public static CommentDTO toDTO(CommentEntity commentEntity) {

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setCommentId(commentEntity.getCommentId());
        commentDTO.setCommentText(commentEntity.getCommentText());
        commentDTO.setCommentName(commentEntity.getCommentName());
        commentDTO.setCommentEmail(commentEntity.getCommentEmail());
        commentDTO.setCommentCreatedAt(commentEntity.getCommentCreatedAt());

        commentDTO.setUserDTO(UserMappers.toDTO(commentEntity.getUserEntity()));
        return commentDTO;
    }


}
