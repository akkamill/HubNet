package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.blog.CommentEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BlogDTO {

    private Long blogId;
    private String blogTitle;
    private String blogDescription;
    private String blogContent;
    private String blogTags;
    private String blogMetaTitle;
    private String blogMetaDescription;
    private String blogMetaKeywords;
    private int numberOfViews;

    @Transient
    private MultipartFile blogImage;
    private String blogImagePath;

    private LocalDateTime blogCreatedAt;

    private List<CommentDTO> comments = new ArrayList<>();
    private List<LikeDTO> likes;

//    private UserDTO author;

}
