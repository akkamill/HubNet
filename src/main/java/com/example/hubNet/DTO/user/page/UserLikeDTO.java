package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

@Data
public class UserLikeDTO {

    private Long userLikeId;

    private UserDTO userDTO;
    private UserPostDTO userPostDTO;

}
