package com.example.ecommerceDemo.services.blog;

import com.example.ecommerceDemo.DTO.blog.CommentDTO;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.CommentEntity;
import com.example.ecommerceDemo.repositories.blog.BlogRepository;
import com.example.ecommerceDemo.repositories.blog.CommentRepository;
import com.example.ecommerceDemo.services.mappers.blog.CommentMappers;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }


    public void createComment(Long blogId, CommentDTO commentDTO) {

        BlogEntity blogEntity = blogRepository.findById(blogId).orElseThrow(() ->
                new RuntimeException("Comment not found"));

        CommentEntity commentEntity = CommentMappers.toEntity((commentDTO));
        commentEntity.setBlog(blogEntity);

        commentRepository.save(commentEntity);
        blogEntity.getComments().add(commentEntity);
        CommentMappers.toDTO(commentEntity);
    }




}
