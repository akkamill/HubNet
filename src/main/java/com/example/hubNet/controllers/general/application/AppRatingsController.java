package com.example.hubNet.controllers.general.application;

import com.example.hubNet.DTO.general.application.AppRatingsDTO;
import com.example.hubNet.services.general.application.AppRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/general/applications/appRatings")
public class AppRatingsController {

    private final AppRatingsService appRatingsService;

    @Autowired
    public AppRatingsController(AppRatingsService appRatingsService) {
        this.appRatingsService = appRatingsService;
    }

    @PostMapping("/add/{applicationId}")
    public AppRatingsDTO addAppRating(@PathVariable Long applicationId, @RequestBody AppRatingsDTO ratingDTO) {
        return appRatingsService.createAppRating(applicationId, ratingDTO);
    }
}
