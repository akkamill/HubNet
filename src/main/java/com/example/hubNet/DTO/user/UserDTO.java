package com.example.hubNet.DTO.user;

import com.example.hubNet.DTO.app.TaskCommentDTO;
import com.example.hubNet.DTO.blog.LikeDTO;
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
