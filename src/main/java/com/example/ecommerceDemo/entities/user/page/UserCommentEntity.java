package com.example.ecommerceDemo.entities.user.page;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@Table(name = "user_comments")
public class UserCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCommentId;

    private String commentText;

    @Transient
    private MultipartFile commentImage;
    private String commentImagePath;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private UserPostEntity commentPost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
