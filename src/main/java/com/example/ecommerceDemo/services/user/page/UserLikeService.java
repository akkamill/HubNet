package com.example.ecommerceDemo.services.user.page;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.user.page.UserLikeEntity;
import com.example.ecommerceDemo.entities.user.page.UserPostEntity;
import com.example.ecommerceDemo.repositories.user.page.UserLikeRepository;
import com.example.ecommerceDemo.repositories.user.page.UserPostRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLikeService {

    private final UserLikeRepository userLikeRepository;
    private final UserPostRepository userPostRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserLikeService(UserLikeRepository userLikeRepository, UserPostRepository userPostRepository, UserRepository userRepository) {
        this.userLikeRepository = userLikeRepository;
        this.userPostRepository = userPostRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public void createLike(Long userPostId, Long userId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserPostEntity userPost = userPostRepository.findById(userPostId).orElseThrow(()
                -> new RuntimeException("User post not found"));

        UserLikeEntity userLikeEntity = new UserLikeEntity();
        userLikeEntity.setUser(user);
        userLikeEntity.setUserPost(userPost);

        userLikeRepository.save(userLikeEntity);
    }

    @Transactional
    public List<UserEntity> getLikers(Long userPostId) {
        return userLikeRepository.findLikersByUserPostId(userPostId);
    }

    @Transactional
    public int getLikeCount(Long userPostId) {
        return userLikeRepository.countByUserPostId(userPostId);
    }

    @Transactional
    public void deleteLike(Long userLikeId) {
        userLikeRepository.deleteById(userLikeId);
    }
}
