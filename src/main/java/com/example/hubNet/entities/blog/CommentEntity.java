package com.example.hubNet.entities.blog;

import com.example.hubNet.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "blog_comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentText;
    private String commentName;
    private String commentEmail;


    @CreationTimestamp
    private LocalDateTime commentCreatedAt;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private BlogEntity blog;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;





}
