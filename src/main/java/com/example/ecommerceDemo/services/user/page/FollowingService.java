//package com.example.ecommerceDemo.services.user.page;
//
//import com.example.ecommerceDemo.DTO.user.page.FollowingDTO;
//import com.example.ecommerceDemo.entities.user.UserEntity;
//import com.example.ecommerceDemo.entities.user.page.FollowingEntity;
//import com.example.ecommerceDemo.repositories.user.UserRepository;
//import com.example.ecommerceDemo.repositories.user.page.FollowingRepository;
//import com.example.ecommerceDemo.services.mappers.user.page.FollowingMappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FollowingService {
//
//    private final FollowingRepository followingRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public FollowingService(FollowingRepository followingRepository, UserRepository userRepository) {
//        this.followingRepository = followingRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Transactional
//    public FollowingDTO addFollowing(Long userId, Long followingId) {
//        UserEntity user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        UserEntity following = userRepository.findById(followingId)
//                .orElseThrow(() -> new RuntimeException("Following user not found"));
//
//        FollowingEntity followingEntity = new FollowingEntity();
//        followingEntity.setUser(user);
//        followingEntity.setFollowing(following);
//
//        FollowingEntity savedFollowing = followingRepository.save(followingEntity);
//        return FollowingMappers.toDTO(savedFollowing);
//    }
//
//    @Transactional
//    public void removeFollowing(Long userId, Long followingId) {
//        FollowingEntity followingEntity = followingRepository.findByUserIdAndFollowingId(userId, followingId)
//                .orElseThrow(() -> new RuntimeException("Following relationship not found"));
//        followingRepository.delete(followingEntity);
//    }
//
//    @Transactional
//    public List<FollowingDTO> getFollowings(Long userId) {
//        List<FollowingEntity> followings = followingRepository.findAllByUserId(userId);
//        List<FollowingDTO> followingDTOs = new ArrayList<>();
//        for (FollowingEntity following : followings) {
//            followingDTOs.add(FollowingMappers.toDTO(following));
//        }
//        return followingDTOs;
//    }
//
//    @Transactional
//    public FollowingDTO getFollowing(Long userId, Long followingId) {
//        FollowingEntity followingEntity = followingRepository.findByUserIdAndFollowingId(userId, followingId)
//                .orElseThrow(() -> new RuntimeException("Following relationship not found"));
//        return FollowingMappers.toDTO(followingEntity);
//    }
//
//
//}
