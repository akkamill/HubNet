package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class GalleryDTO {

    private Long galleryId;
    private String description;

    private MultipartFile image;
    private String imagePath;

    private LocalDateTime createdAt;

    UserDTO userDTO;
    AlbumDTO albumDTO;
}
