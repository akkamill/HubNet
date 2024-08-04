package com.example.ecommerceDemo.DTO.user;

import com.example.ecommerceDemo.DTO.app.TaskCommentDTO;
import com.example.ecommerceDemo.DTO.blog.LikeDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {

    private Long userId;
    private String name;
    private String lastName;
    private String password;
    private String emailAddress;
    private LocalDateTime userCreatedAt;

    private UserDetailsDTO userDetailsDTO;

//    ---------------------------------------------------------------------------------------------------------------//

    private List<LikeDTO> likes;
    private List<TaskCommentDTO> taskComments;
}
