package com.example.hubNet.DTO.blog;


import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

@Data
public class LikeDTO {


    private Long likeId;
    private BlogDTO blog;
    private UserDTO user;

}
