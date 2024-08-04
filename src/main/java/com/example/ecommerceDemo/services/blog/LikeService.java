package com.example.ecommerceDemo.services.blog;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.repositories.blog.BlogRepository;
import com.example.ecommerceDemo.repositories.blog.LikeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository,
                       BlogRepository blogRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createLike(Long blogId, Long userId) {

        BlogEntity blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (likeRepository.existsByUserAndBlog(user, blog)) {
            throw new RuntimeException("User already liked the blog");
        }

        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setUser(user);
        likeEntity.setBlog(blog);

        likeRepository.save(likeEntity);

    }

    @Transactional
    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    @Transactional
    public int getLikeCount(Long blogId) {
        return likeRepository.countByBlogId(blogId);
    }

    @Transactional
    public List<UserEntity> getLikers(Long blogId) {
        return likeRepository.findLikersByBlogId(blogId);
    }


}
