package com.example.hubNet.DTO.user.page;

import com.example.hubNet.DTO.user.UserDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AlbumDTO {

    private Long albumId;
    private String title;
    private String description;

    private LocalDateTime createdAt;

    private UserDTO userDTO;
    private List<GalleryDTO> galleryItems;

}

