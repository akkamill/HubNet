package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.CommentDTO;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.CommentEntity;
import com.example.ecommerceDemo.repositories.BlogRepository;
import com.example.ecommerceDemo.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }


    public CommentDTO createComment(Long id, CommentDTO commentDTO) {

        BlogEntity blogEntity = blogRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Comment not found"));

        CommentEntity commentEntity = toEntity((commentDTO));
        commentEntity.setBlog(blogEntity);

        commentRepository.save(commentEntity);
        blogEntity.getComments().add(commentEntity);

        return toDTO(commentEntity);
    }


    //---------------------------------------------------------------------------------------------------------------//


    public static CommentDTO toDTO(CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentEntity.getCommentId());
        commentDTO.setCommentText(commentEntity.getCommentText());
        commentDTO.setCommentName(commentEntity.getCommentName());
        commentDTO.setCommentEmail(commentEntity.getCommentEmail());
        commentDTO.setCommentCreatedAt(commentEntity.getCommentCreatedAt());
        commentDTO.setBlog(commentEntity.getBlog());
        return commentDTO;
    }

    public static CommentEntity toEntity(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentId(commentDTO.getCommentId());
        commentEntity.setCommentText(commentDTO.getCommentText());
        commentEntity.setCommentName(commentDTO.getCommentName());
        commentEntity.setCommentEmail(commentDTO.getCommentEmail());
        commentEntity.setCommentCreatedAt(commentDTO.getCommentCreatedAt());
        commentEntity.setBlog(commentDTO.getBlog());
        return commentEntity;
    }

}
