package com.example.ecommerceDemo.DTO.user.page;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import lombok.Data;

@Data
public class FriendDTO {

    private Long friendId;

    private UserDTO userDTO;
    private UserDTO friendDTO;
}
