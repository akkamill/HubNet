package com.example.ecommerceDemo.DTO.blog;


import com.example.ecommerceDemo.DTO.user.UserDTO;
import lombok.Data;

@Data
public class LikeDTO {


    private Long likeId;
    private BlogDTO blog;
    private UserDTO user;

}
