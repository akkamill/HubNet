//package com.example.ecommerceDemo.services.user.page;
//
//import com.example.ecommerceDemo.DTO.user.page.FriendDTO;
//import com.example.ecommerceDemo.entities.user.UserEntity;
//import com.example.ecommerceDemo.entities.user.page.FriendEntity;
//import com.example.ecommerceDemo.repositories.user.UserRepository;
//import com.example.ecommerceDemo.repositories.user.page.FriendRepository;
//import com.example.ecommerceDemo.services.mappers.user.page.FriendMappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FriendService {
//
//    private final FriendRepository friendRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public FriendService(FriendRepository friendRepository, UserRepository userRepository) {
//        this.friendRepository = friendRepository;
//        this.userRepository = userRepository;
//    }
//
//
//    @Transactional
//    public FriendDTO addFriend(Long userId, Long friendId) {
//        UserEntity user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        UserEntity friend = userRepository.findById(friendId)
//                .orElseThrow(() -> new RuntimeException("Friend not found"));
//
//        FriendEntity friendEntity = new FriendEntity();
//        friendEntity.setUser(user);
//        friendEntity.setFriend(friend);
//
//        FriendEntity savedFriend = friendRepository.save(friendEntity);
//        return FriendMappers.toDTO(savedFriend);
//    }
//
//    @Transactional
//    public void removeFriend(Long userId, Long friendId) {
//        FriendEntity friendEntity = friendRepository.findByUserIdAndFriendId(userId, friendId)
//                .orElseThrow(() -> new RuntimeException("Friend relationship not found"));
//        friendRepository.delete(friendEntity);
//    }
//
//    @Transactional
//    public List<FriendDTO> getAllFriends(Long userId) {
//        List<FriendEntity> friends = friendRepository.findAllByUserId(userId);
//        List<FriendDTO> friendDTOs = new ArrayList<>();
//        for (FriendEntity friend : friends) {
//            friendDTOs.add(FriendMappers.toDTO(friend));
//        }
//        return friendDTOs;
//    }
//
//    @Transactional
//    public FriendDTO getFriend(Long userId, Long friendId) {
//        FriendEntity friendEntity = friendRepository.findByUserIdAndFriendId(userId, friendId)
//                .orElseThrow(() -> new RuntimeException("Friend relationship not found"));
//        return FriendMappers.toDTO(friendEntity);
//    }
//
//}
