package com.example.ecommerceDemo.DTO.user.page;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import lombok.Data;

@Data
public class FollowerDTO {

    private Long followerId;

    private UserDTO userDTO;
    private UserDTO followerDTO;
}
