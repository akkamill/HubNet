package com.example.hubNet.services.mappers.user.page;

import com.example.hubNet.DTO.user.page.FriendDTO;
import com.example.hubNet.entities.user.page.FriendEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class FriendMappers {

    public static FriendEntity toEntity(FriendDTO friendDTO) {
        if (friendDTO == null) return null;

        FriendEntity friend = new FriendEntity();
        friend.setFriendId(friendDTO.getFriendId());
        friend.setUser(UserMappers.toEntity(friendDTO.getUserDTO()));
        friend.setFriend(UserMappers.toEntity(friendDTO.getFriendDTO()));

        return friend;
    }

    public static FriendDTO toDTO(FriendEntity friend) {
        if (friend == null) return null;

        FriendDTO friendDTO = new FriendDTO();
        friendDTO.setFriendId(friend.getFriendId());
        friendDTO.setUserDTO(UserMappers.toDTO(friend.getUser()));
        friendDTO.setFriendDTO(UserMappers.toDTO(friend.getFriend()));

        return friendDTO;
    }
}
