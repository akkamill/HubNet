package com.example.hubNet.services.mappers.user.page;

import com.example.hubNet.DTO.user.page.FollowerDTO;
import com.example.hubNet.entities.user.page.FollowerEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class FollowerMappers {

    public static FollowerEntity toEntity(FollowerDTO followerDTO) {
        if (followerDTO == null) return null;

        FollowerEntity follower = new FollowerEntity();
        follower.setFollowerId(followerDTO.getFollowerId());
        follower.setUser(UserMappers.toEntity(followerDTO.getUserDTO()));
        follower.setFollower(UserMappers.toEntity(followerDTO.getFollowerDTO()));

        return follower;
    }

    public static FollowerDTO toDTO(FollowerEntity follower) {
        if (follower == null) return null;

        FollowerDTO followerDTO = new FollowerDTO();
        followerDTO.setFollowerId(follower.getFollowerId());
        followerDTO.setUserDTO(UserMappers.toDTO(follower.getUser()));
        followerDTO.setFollowerDTO(UserMappers.toDTO(follower.getFollower()));

        return followerDTO;
    }
}
