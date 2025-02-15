//package com.example.ecommerceDemo.services.user.page;
//
//import com.example.ecommerceDemo.DTO.user.page.FollowerDTO;
//import com.example.ecommerceDemo.entities.user.UserEntity;
//import com.example.ecommerceDemo.entities.user.page.FollowerEntity;
//import com.example.ecommerceDemo.repositories.user.UserRepository;
//import com.example.ecommerceDemo.repositories.user.page.FollowerRepository;
//import com.example.ecommerceDemo.services.mappers.user.page.FollowerMappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FollowerService {
//
//    private final FollowerRepository followerRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public FollowerService(FollowerRepository followerRepository, UserRepository userRepository) {
//        this.followerRepository = followerRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Transactional
//    public FollowerDTO addFollower(Long userId, Long followerId) {
//        UserEntity user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        UserEntity follower = userRepository.findById(followerId)
//                .orElseThrow(() -> new RuntimeException("Follower not found"));
//
//        FollowerEntity followerEntity = new FollowerEntity();
//        followerEntity.setUser(user);
//        followerEntity.setFollower(follower);
//
//        FollowerEntity savedFollower = followerRepository.save(followerEntity);
//        return FollowerMappers.toDTO(savedFollower);
//    }
//
//    @Transactional
//    public void removeFollower(Long userId, Long followerId) {
//        FollowerEntity followerEntity = followerRepository.findByUserIdAndFollowerId(userId, followerId)
//                .orElseThrow(() -> new RuntimeException("Follower relationship not found"));
//        followerRepository.delete(followerEntity);
//    }
//
//    @Transactional
//    public List<FollowerDTO> getAllFollowers(Long userId) {
//        List<FollowerEntity> followers = followerRepository.findAllByUserId(userId);
//        List<FollowerDTO> followerDTOs = new ArrayList<>();
//        for (FollowerEntity follower : followers) {
//            followerDTOs.add(FollowerMappers.toDTO(follower));
//        }
//        return followerDTOs;
//    }
//
//    @Transactional
//    public FollowerDTO getFollower(Long userId, Long followerId) {
//        FollowerEntity followerEntity = followerRepository.findByUserIdAndFollowerId(userId, followerId)
//                .orElseThrow(() -> new RuntimeException("Follower relationship not found"));
//        return FollowerMappers.toDTO(followerEntity);
//    }
//}
