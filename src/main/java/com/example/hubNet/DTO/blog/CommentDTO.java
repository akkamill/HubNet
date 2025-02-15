package com.example.hubNet.DTO.blog;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private Long commentId;
    private String commentText;
    private String commentName;
    private String commentEmail;
    private LocalDateTime commentCreatedAt;
    private BlogDTO blogDTO;
    private UserDTO userDTO = new UserDTO();


}
