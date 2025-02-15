package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

@Data
public class FollowingDTO {

    private Long followingId;

    private UserDTO userDTO;
    private UserDTO followingDTO;
}
