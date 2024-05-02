package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.blog.BlogEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private Long commentId;
    private String commentText;
    private String commentName;
    private String commentEmail;
    private LocalDateTime commentCreatedAt;
    private BlogEntity blog;


    //    private UserEntity userEntity;





}
