package com.example.ecommerceDemo.entities.blog;

import com.example.ecommerceDemo.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private BlogEntity blog;

    private LikeEntity(Builder builder) {
        setLikeId(builder.likeId);
        setUser(builder.user);
        setBlog(builder.blog);
    }


    public static final class Builder {
        private Long likeId;
        private UserEntity user;
        private BlogEntity blog;

        public Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder likeId(Long val) {
            likeId = val;
            return this;
        }

        public Builder user(UserEntity val) {
            user = val;
            return this;
        }

        public Builder blog(BlogEntity val) {
            blog = val;
            return this;
        }

        public LikeEntity build() {
            return new LikeEntity(this);
        }
    }
}
