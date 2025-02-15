package com.example.hubNet.controllers.user.page;

import com.example.hubNet.DTO.user.page.AlbumDTO;
import com.example.hubNet.services.user.page.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<AlbumDTO> createAlbum(@PathVariable Long userId,
                                                @RequestBody AlbumDTO albumDTO) {
        AlbumDTO createdAlbum = albumService.createAlbum(userId, albumDTO);
        return ResponseEntity.ok(createdAlbum);
    }

    @PutMapping("/update/{albumId}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable Long albumId,
                                                @RequestBody AlbumDTO albumDTO) {
        AlbumDTO updatedAlbum = albumService.updateAlbum(albumId, albumDTO);
        return ResponseEntity.ok(updatedAlbum);
    }

    @DeleteMapping("/delete/{albumId}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbum(albumId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        List<AlbumDTO> albumList = albumService.getAllAlbums();
        return ResponseEntity.ok(albumList);
    }

    @GetMapping("/get/{albumId}")
    public ResponseEntity<AlbumDTO> getAlbum(@PathVariable Long albumId) {
        AlbumDTO albumDTO = albumService.getAlbum(albumId);
        return ResponseEntity.ok(albumDTO);
    }
}
