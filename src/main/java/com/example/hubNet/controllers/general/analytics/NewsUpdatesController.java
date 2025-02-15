package com.example.hubNet.controllers.general.analytics;

import com.example.hubNet.DTO.general.analytics.NewsUpdatesDTO;
import com.example.hubNet.services.general.analytics.NewsUpdatesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/analytics")
public class NewsUpdatesController {

    private final NewsUpdatesService newsUpdatesService;

    public NewsUpdatesController(NewsUpdatesService newsUpdatesService) {
        this.newsUpdatesService = newsUpdatesService;
    }

    @GetMapping("get/news/{userId}")
    public List<NewsUpdatesDTO> getNewsUpdates(@PathVariable Long userId) {
        return newsUpdatesService.getNewsUpdatesByUserId(userId);
    }
}
