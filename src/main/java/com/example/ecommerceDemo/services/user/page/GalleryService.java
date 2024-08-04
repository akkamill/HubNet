package com.example.ecommerceDemo.services.user.page;

import com.example.ecommerceDemo.DTO.user.page.AlbumDTO;
import com.example.ecommerceDemo.DTO.user.page.GalleryDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.user.page.AlbumEntity;
import com.example.ecommerceDemo.entities.user.page.GalleryEntity;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.repositories.user.page.AlbumRepository;
import com.example.ecommerceDemo.repositories.user.page.GalleryRepository;
import com.example.ecommerceDemo.services.mappers.user.page.GalleryMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;
    private final UserRepository userRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository, UserRepository userRepository, AlbumRepository albumRepository) {
        this.galleryRepository = galleryRepository;
        this.userRepository = userRepository;
        this.albumRepository = albumRepository;
    }

    @Transactional
    public GalleryDTO createGalleryItem(Long userId, GalleryDTO galleryDTO, MultipartFile galleryImage) throws IOException {

        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        GalleryEntity gallery = GalleryMappers.toEntity(galleryDTO);
        gallery.setUser(user);

        if (galleryImage != null && !galleryImage.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\galleryPhotos\\";

            String filePath = uploadDir + gallery.getGalleryId() + "_" + galleryImage.getOriginalFilename();

            Path galleryPhotoPath = Paths.get(filePath);
            Files.write(galleryPhotoPath, galleryImage.getBytes());

            gallery.setImagePath(filePath);
        }

        if (galleryDTO.getAlbumDTO() != null) {
            AlbumDTO albumDTO = galleryDTO.getAlbumDTO();
            AlbumEntity album = albumRepository.findById(albumDTO.getAlbumId())
                    .orElseThrow(() -> new RuntimeException("Album not found"));
            gallery.setAlbums(album);
        }
        return GalleryMappers.toDTO(gallery);
    }

    @Transactional
    public GalleryDTO updateGalleryItem(Long galleryId, GalleryDTO galleryDTO) {
        GalleryEntity gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new IllegalArgumentException("Gallery item not found"));
        gallery.setDescription(galleryDTO.getDescription());

        galleryRepository.save(gallery);
        return GalleryMappers.toDTO(gallery);

    }

    @Transactional
    public void deleteGalleryItem(Long galleryId) {
        galleryRepository.deleteById(galleryId);
    }

    @Transactional
    public List<GalleryDTO> getAll() {
        List<GalleryEntity> entities = galleryRepository.findAll();
        List<GalleryDTO> dtoList = new ArrayList<>();
        for (GalleryEntity g : entities ) {
            GalleryDTO galleryDTO = GalleryMappers.toDTO(g);

            dtoList.add(galleryDTO);
        }
        return dtoList;
    }

    @Transactional
    public GalleryDTO getGalleryItem(Long galleryId) {
        GalleryEntity gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new IllegalArgumentException("Gallery item not found"));
        return GalleryMappers.toDTO(gallery);
    }

}


