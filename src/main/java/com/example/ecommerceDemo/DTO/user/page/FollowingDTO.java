package com.example.ecommerceDemo.DTO.user.page;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import lombok.Data;

@Data
public class FollowingDTO {

    private Long followingId;

    private UserDTO userDTO;
    private UserDTO followingDTO;
}
