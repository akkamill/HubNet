package com.example.hubNet.repositories.user.page;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.user.page.UserLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikeRepository extends JpaRepository<UserLikeEntity, Long> {

    @Query("SELECT COUNT(l) FROM UserLikeEntity l WHERE l.userPost.userPostId = ?1")
    int countByUserPostId(Long userPostId);

    @Query("SELECT DISTINCT l.user FROM UserLikeEntity l WHERE l.userPost.userPostId = ?1")
    List<UserEntity> findLikersByUserPostId(Long userPostId);

}
