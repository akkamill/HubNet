package com.example.hubNet.repositories.blog;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.blog.BlogEntity;
import com.example.hubNet.entities.blog.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    @Query("SELECT COUNT(l) FROM LikeEntity l WHERE l.blog.blogId = ?1")
    int countByBlogId(Long blogId);

    @Query("SELECT DISTINCT l.user FROM LikeEntity l WHERE l.blog.blogId = ?1")
    List<UserEntity> findLikersByBlogId(Long blogId);


    boolean existsByUserAndBlog(UserEntity user, BlogEntity blog);


}
