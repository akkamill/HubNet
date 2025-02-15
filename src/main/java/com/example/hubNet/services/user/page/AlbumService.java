package com.example.hubNet.services.user.page;

import com.example.hubNet.DTO.user.page.AlbumDTO;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.user.page.AlbumEntity;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.repositories.user.page.AlbumRepository;
import com.example.hubNet.services.mappers.user.page.AlbumMappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    public AlbumService(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public AlbumDTO createAlbum(Long userId, AlbumDTO albumDTO) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AlbumEntity album = AlbumMappers.toEntity(albumDTO);
        album.setUser(user);

        album = albumRepository.save(album);
        return AlbumMappers.toDTO(album);
    }


    @Transactional
    public AlbumDTO updateAlbum(Long albumId, AlbumDTO albumDTO) {
        AlbumEntity album = albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("Album not found"));

        album.setTitle(albumDTO.getTitle());
        album.setDescription(albumDTO.getDescription());

        albumRepository.save(album);
        return AlbumMappers.toDTO(album);
    }

    @Transactional
    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }

    @Transactional
    public List<AlbumDTO> getAllAlbums() {
        List<AlbumEntity> albums = albumRepository.findAll();
        List<AlbumDTO> albumDTOs = new ArrayList<>();
        for (AlbumEntity album : albums) {
            albumDTOs.add(AlbumMappers.toDTO(album));
        }
        return albumDTOs;
    }

    @Transactional
    public AlbumDTO getAlbum(Long albumId) {
        AlbumEntity album = albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("Album not found"));
        return AlbumMappers.toDTO(album);
    }

}
