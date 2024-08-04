package com.example.ecommerceDemo.entities.user.page;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "user_posts")
public class UserPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPostId;

    private String postBody;

    @Transient
    private MultipartFile postImage;
    private String postImagePath;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_post")
    private UserEntity user;

    @OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL)
    private List<UserLikeEntity> userLike;

    @OneToMany(mappedBy = "commentPost")
    private List<UserCommentEntity> userComment;


}
