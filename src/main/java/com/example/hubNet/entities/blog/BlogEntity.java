package com.example.hubNet.entities.blog;

import com.example.hubNet.entities.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "blog")
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] blogImage;
//    private String blogImagePath;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "blog")
    @JsonIgnore
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @ManyToOne
    @JoinColumn(name = "user_blog")
    private UserEntity userEntity;

    @OneToOne(mappedBy = "blog", cascade = CascadeType.ALL)
    private BlogMetricsEntity blogMetrics;

}
