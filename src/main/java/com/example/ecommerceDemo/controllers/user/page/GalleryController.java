package com.example.ecommerceDemo.controllers.user.page;

import com.example.ecommerceDemo.DTO.user.page.GalleryDTO;
import com.example.ecommerceDemo.services.user.page.GalleryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/galleries")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<GalleryDTO> createGalleryItem(
            @PathVariable Long userId,
            @RequestPart("galleryDTO") GalleryDTO galleryDTO,
            @RequestPart("image") MultipartFile galleryImage) {
        try {
            GalleryDTO createdGallery = galleryService.createGalleryItem(userId, galleryDTO, galleryImage);
            return ResponseEntity.ok(createdGallery);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("update/{galleryId}")
    public ResponseEntity<GalleryDTO> updateGalleryItem(
            @PathVariable Long galleryId,
            @RequestBody GalleryDTO galleryDTO) {
        GalleryDTO updatedGallery = galleryService.updateGalleryItem(galleryId, galleryDTO);
        return ResponseEntity.ok(updatedGallery);
    }

    @DeleteMapping("delete/{galleryId}")
    public ResponseEntity<Void> deleteGalleryItem(@PathVariable Long galleryId) {
        galleryService.deleteGalleryItem(galleryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GalleryDTO>> getAllGalleryItems() {
        List<GalleryDTO> galleryList = galleryService.getAll();
        return ResponseEntity.ok(galleryList);
    }

    @GetMapping("/get/{galleryId}")
    public ResponseEntity<GalleryDTO> getGalleryItem(@PathVariable Long galleryId) {
        GalleryDTO galleryDTO = galleryService.getGalleryItem(galleryId);
        return ResponseEntity.ok(galleryDTO);
    }
}
