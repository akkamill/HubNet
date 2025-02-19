package com.example.hubNet.controllers.user;

import com.example.hubNet.DTO.user.SocialMediaLinksDTO;
import com.example.hubNet.services.user.SocialMediaLinksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social-media")
public class SocialMediaLinksController {

    private final SocialMediaLinksService socialMediaLinksService;

    public SocialMediaLinksController(SocialMediaLinksService socialMediaLinksService) {
        this.socialMediaLinksService = socialMediaLinksService;
    }

    @PostMapping("/create/{userDetailsId}")
    public ResponseEntity<SocialMediaLinksDTO> createSocialMedia(@PathVariable Long userDetailsId,
                                                                 @RequestBody SocialMediaLinksDTO socialMediaLinksDTO) {
        socialMediaLinksService.createSocialMedia(userDetailsId, socialMediaLinksDTO);
        return ResponseEntity.ok().build();
    }
}
