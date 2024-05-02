package com.example.ecommerceDemo.entities.blog;

import com.example.ecommerceDemo.entities.ReviewEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    private String blogTitle;

    @Lob
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

    @CreationTimestamp
    private LocalDateTime blogCreatedAt;

    @OneToMany(mappedBy = "blog")
    @JsonIgnore
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    private BlogEntity(Builder builder) {
        setBlogId(builder.blogId);
        setBlogTitle(builder.blogTitle);
        setBlogDescription(builder.blogDescription);
        setBlogContent(builder.blogContent);
        setBlogTags(builder.blogTags);
        setBlogMetaTitle(builder.blogMetaTitle);
        setBlogMetaDescription(builder.blogMetaDescription);
        setBlogMetaKeywords(builder.blogMetaKeywords);
        setNumberOfViews(builder.numberOfViews);
        setBlogImage(builder.blogImage);
        setBlogImagePath(builder.blogImagePath);
        setBlogCreatedAt(builder.blogCreatedAt);
        setComments(builder.comments);
        setLikes(builder.likes);
    }

    public static final class Builder {
        private Long blogId;
        private String blogTitle;
        private String blogDescription;
        private String blogContent;
        private String blogTags;
        private String blogMetaTitle;
        private String blogMetaDescription;
        private String blogMetaKeywords;
        private int numberOfViews;
        private MultipartFile blogImage;
        private String blogImagePath;
        private LocalDateTime blogCreatedAt;
        private List<CommentEntity> comments;
        private List<LikeEntity> likes;

        public Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder blogId(Long val) {
            blogId = val;
            return this;
        }

        public Builder blogTitle(String val) {
            blogTitle = val;
            return this;
        }

        public Builder blogDescription(String val) {
            blogDescription = val;
            return this;
        }

        public Builder blogContent(String val) {
            blogContent = val;
            return this;
        }

        public Builder blogTags(String val) {
            blogTags = val;
            return this;
        }

        public Builder blogMetaTitle(String val) {
            blogMetaTitle = val;
            return this;
        }

        public Builder blogMetaDescription(String val) {
            blogMetaDescription = val;
            return this;
        }

        public Builder blogMetaKeywords(String val) {
            blogMetaKeywords = val;
            return this;
        }

        public Builder numberOfViews(int val) {
            numberOfViews = val;
            return this;
        }

        public Builder blogImage(MultipartFile val) {
            blogImage = val;
            return this;
        }

        public Builder blogImagePath(String val) {
            blogImagePath = val;
            return this;
        }

        public Builder blogCreatedAt(LocalDateTime val) {
            blogCreatedAt = val;
            return this;
        }

        public Builder comments(List<CommentEntity> val) {
            comments = val;
            return this;
        }

        public Builder likes(List<LikeEntity> val) {
            likes = val;
            return this;
        }

        public BlogEntity build() {
            return new BlogEntity(this);
        }
    }


//    @ManyToOne
//    @JoinColumn(name = "author_id", nullable = false)
//    private UserEntity author;




}
