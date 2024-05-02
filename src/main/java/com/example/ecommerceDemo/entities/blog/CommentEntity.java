package com.example.ecommerceDemo.entities.blog;

import com.example.ecommerceDemo.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.mapping.Join;

import java.time.LocalDateTime;

@Data
@Entity
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

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity userEntity;





}
