package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

@Data
public class FriendDTO {

    private Long friendId;

    private UserDTO userDTO;
    private UserDTO friendDTO;
}
