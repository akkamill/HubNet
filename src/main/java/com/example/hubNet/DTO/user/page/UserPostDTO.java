package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserPostDTO {

    private Long userPostId;
    private String postBody;

    private MultipartFile userPostImage;
    private String postImagePath;

    private LocalDateTime createdAt;

    private UserDTO userDTO;
    private List<UserLikeDTO> userLikes;
    private List<UserCommentDTO> userComments;


}
