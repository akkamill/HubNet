//package com.example.ecommerceDemo.repositories.user.page;
//
//import com.example.ecommerceDemo.entities.user.page.FollowerEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface FollowerRepository extends JpaRepository<FollowerEntity, Long> {
//
//    Optional<FollowerEntity> findByUserIdAndFollowerId(Long userId, Long followerId);
//
//    List<FollowerEntity> findAllByUserId(Long userId);
//
//}
