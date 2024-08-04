package com.example.ecommerceDemo.DTO.user.page;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserCommentDTO {

    private Long userCommentId;
    private String commentText;

    private MultipartFile commentImage;
    private String commentImagePath;

    private UserPostDTO userPostDTO;
    private UserDTO userDTO;
}
