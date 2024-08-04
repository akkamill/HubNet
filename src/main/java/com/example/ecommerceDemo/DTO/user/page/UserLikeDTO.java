package com.example.ecommerceDemo.DTO.user.page;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import lombok.Data;

@Data
public class UserLikeDTO {

    private Long userLikeId;

    private UserDTO userDTO;
    private UserPostDTO userPostDTO;

}
