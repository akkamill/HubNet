package com.example.ecommerceDemo.controllers.app;

import com.example.ecommerceDemo.DTO.app.SectionDTO;
import com.example.ecommerceDemo.services.app.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSection(@RequestBody SectionDTO sectionDTO) {
        return ResponseEntity.ok(sectionService.createSection(sectionDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSections() {
        return ResponseEntity.ok(sectionService.getAllSections());
    }

    @GetMapping("/get/{sectionId}")
    public ResponseEntity<?> getSectionById(@PathVariable Long sectionId) {
        return ResponseEntity.ok(sectionService.getSectionById(sectionId));
    }

    @DeleteMapping("/delete/{sectionId}")
    public ResponseEntity<?> deleteSection(@PathVariable Long sectionId) {
        sectionService.deleteSection(sectionId);
        return ResponseEntity.ok("Successfully deleted");
    }
}
