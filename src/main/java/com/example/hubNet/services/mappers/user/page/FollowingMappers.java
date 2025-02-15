package com.example.hubNet.services.mappers.user.page;

import com.example.hubNet.DTO.user.page.FollowingDTO;
import com.example.hubNet.entities.user.page.FollowingEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class FollowingMappers {

    public static FollowingEntity toEntity(FollowingDTO followingDTO) {
        if (followingDTO == null) return null;

        FollowingEntity following = new FollowingEntity();
        following.setFollowingId(followingDTO.getFollowingId());
        following.setUser(UserMappers.toEntity(followingDTO.getUserDTO()));
        following.setFollowing(UserMappers.toEntity(followingDTO.getFollowingDTO()));

        return following;
    }

    public static FollowingDTO toDTO(FollowingEntity following) {
        if (following == null) return null;

        FollowingDTO followingDTO = new FollowingDTO();
        followingDTO.setFollowingId(following.getFollowingId());
        followingDTO.setUserDTO(UserMappers.toDTO(following.getUser()));
        followingDTO.setFollowingDTO(UserMappers.toDTO(following.getFollowing()));

        return followingDTO;
    }
}
