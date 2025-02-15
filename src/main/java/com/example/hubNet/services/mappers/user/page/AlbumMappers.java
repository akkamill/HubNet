package com.example.hubNet.services.mappers.user.page;

import com.example.hubNet.DTO.user.page.AlbumDTO;
import com.example.hubNet.DTO.user.page.GalleryDTO;
import com.example.hubNet.entities.user.page.AlbumEntity;
import com.example.hubNet.entities.user.page.GalleryEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumMappers {

    public static AlbumDTO toDTO(AlbumEntity album) {
        if (album == null) {
            return null;
        }

        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setAlbumId(album.getAlbumId());
        albumDTO.setTitle(album.getTitle());
        albumDTO.setDescription(album.getDescription());

        // Convert User entity to UserDTO
        if (album.getUser() != null) {
            albumDTO.setUserDTO(UserMappers.toDTO(album.getUser()));

        }
        return albumDTO;
    }

    public static AlbumEntity toEntity(AlbumDTO albumDTO) {
        if (albumDTO == null) {
            return null;
        }

        AlbumEntity album = new AlbumEntity();
        album.setAlbumId(albumDTO.getAlbumId());
        album.setTitle(albumDTO.getTitle());
        album.setDescription(albumDTO.getDescription());

        album.setUser(UserMappers.toEntity(albumDTO.getUserDTO()));

        return album;
    }

    public static List<GalleryEntity> toEntityList(List<GalleryDTO> galleryDTOList) {
        if (galleryDTOList == null) {
            return Collections.emptyList();
        }
        return galleryDTOList.stream().map(GalleryMappers::toEntity).collect(Collectors.toList());
    }

    public static List<GalleryDTO> toDTOList(List<GalleryEntity> galleryEntities) {
        return galleryEntities.stream().map(GalleryMappers::toDTO).collect(Collectors.toList());
    }
}
