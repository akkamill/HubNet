package com.example.hubNet.services.mappers.user.page;

import com.example.hubNet.DTO.user.page.GalleryDTO;
import com.example.hubNet.entities.user.page.GalleryEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class GalleryMappers {

    public static GalleryEntity toEntity(GalleryDTO galleryDTO) {
        if (galleryDTO == null) return null;

        GalleryEntity gallery = new GalleryEntity();
        gallery.setGalleryId(galleryDTO.getGalleryId());
        gallery.setDescription(galleryDTO.getDescription());
        gallery.setImagePath(galleryDTO.getImagePath());
        gallery.setUser(UserMappers.toEntity(galleryDTO.getUserDTO()));

        // Handle image if necessary
        // MultipartFile image = galleryDTO.getImage();

        return gallery;
    }

    public static GalleryDTO toDTO(GalleryEntity gallery) {
        if (gallery == null) return null;

        GalleryDTO galleryDTO = new GalleryDTO();
        galleryDTO.setGalleryId(gallery.getGalleryId());
        galleryDTO.setDescription(gallery.getDescription());
        galleryDTO.setImagePath(gallery.getImagePath());
        galleryDTO.setUserDTO(UserMappers.toDTO(gallery.getUser()));

        return galleryDTO;
    }
}
