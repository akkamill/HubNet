package com.example.hubNet.services.blog;

import com.example.hubNet.DTO.blog.CommentDTO;
import com.example.hubNet.entities.blog.BlogEntity;
import com.example.hubNet.entities.blog.CommentEntity;
import com.example.hubNet.repositories.blog.BlogRepository;
import com.example.hubNet.repositories.blog.CommentRepository;
import com.example.hubNet.services.mappers.blog.CommentMappers;
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
