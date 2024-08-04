package com.example.ecommerceDemo.DTO.blog;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import jakarta.persistence.Transient;
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
    private boolean enableComment;
    private boolean isPublic;

    @Transient
    private MultipartFile blogImage;
    private String blogImagePath;

    private LocalDateTime blogCreatedAt;

    private List<CommentDTO> comments = new ArrayList<>();
    private List<LikeDTO> likes;
    private UserDTO userDTO = new UserDTO();

}
