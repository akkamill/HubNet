package com.example.hubNet.controllers.general.users;

import com.example.hubNet.DTO.general.downloads.DownloadsComparisonResponse;
import com.example.hubNet.DTO.general.downloads.DownloadsResponse;
import com.example.hubNet.DTO.general.downloads.PlatformDownloads;
import com.example.hubNet.services.general.DownloadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/downloads")
public class DownloadsController {

    @Autowired
    private DownloadsService downloadsService;

    @GetMapping("/total-downloads")
    public DownloadsResponse getTotalDownloads() {
        return downloadsService.getTotalDownloads();
    }

    @GetMapping("/downloads-comparison")
    public DownloadsComparisonResponse getDownloadsComparison() {
        return downloadsService.getDownloadsComparison();
    }

    @GetMapping("/comparison/platforms")
    public List<PlatformDownloads> compareTotalDownloadsByPlatform() {
        return downloadsService.compareTotalDownloadsByPlatform();
    }
}
