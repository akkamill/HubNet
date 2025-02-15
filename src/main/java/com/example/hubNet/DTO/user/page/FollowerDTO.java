package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

@Data
public class FollowerDTO {

    private Long followerId;

    private UserDTO userDTO;
    private UserDTO followerDTO;
}
