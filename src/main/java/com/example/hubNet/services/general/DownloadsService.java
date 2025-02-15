package com.example.hubNet.services.general;

import com.example.hubNet.DTO.general.downloads.DownloadsComparisonResponse;
import com.example.hubNet.DTO.general.downloads.DownloadsResponse;
import com.example.hubNet.DTO.general.downloads.PlatformDownloads;
import com.example.hubNet.entities.general.users.DownloadsEntity;
import com.example.hubNet.repositories.general.users.DownloadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DownloadsService {


    private final DownloadsRepository downloadsRepository;

    @Autowired
    public DownloadsService(DownloadsRepository downloadsRepository) {
        this.downloadsRepository = downloadsRepository;
    }


    public DownloadsResponse getTotalDownloads() {
        BigDecimal totalDownloadsAllTime = calculateTotalDownloads();

        DownloadsResponse response = new DownloadsResponse();
        response.setTotalDownloadsAllTime(totalDownloadsAllTime);

        return response;
    }


    public DownloadsComparisonResponse getDownloadsComparison() {

        // Calculate downloads for the last 6 months
        BigDecimal totalLastSixMonths = calculateDownloadsInPeriod(LocalDateTime.now().minusMonths(6), LocalDateTime.now());

        // Calculate downloads for the 6 months prior
        BigDecimal totalPreviousSixMonths = calculateDownloadsInPeriod(LocalDateTime.now().minusMonths(12), LocalDateTime.now().minusMonths(6));

        return prepareComparisonResponse(totalLastSixMonths, totalPreviousSixMonths);
    }

    private DownloadsComparisonResponse prepareComparisonResponse(BigDecimal totalLastSixMonths, BigDecimal totalPreviousSixMonths) {
        String comparison;
        String imageUrl;

        if (totalLastSixMonths.compareTo(totalPreviousSixMonths) > 0) {
            comparison = "increased";
            imageUrl = "URL_TO_INCREASE_ICON"; // Replace with actual URL to the increase icon
        } else if (totalLastSixMonths.compareTo(totalPreviousSixMonths) < 0) {
            comparison = "decreased";
            imageUrl = "URL_TO_DECREASE_ICON"; // Replace with actual URL to the decrease icon
        } else {
            comparison = "remained the same";
            imageUrl = "URL_TO_SAME_ICON"; // Replace with actual URL to a neutral icon
        }

        DownloadsComparisonResponse response = new DownloadsComparisonResponse();
        response.setComparison(comparison);
        response.setImageUrl(imageUrl);

        return response;
    }

    public List<PlatformDownloads> compareTotalDownloadsByPlatform() {
        // Fetch all downloads data from the database
        List<DownloadsEntity> downloads = downloadsRepository.findAll();

        // List to hold total downloads by platform
        List<PlatformDownloads> platformDownloadsList = new ArrayList<>();

        // Calculate total downloads for each platform
        for (DownloadsEntity download : downloads) {
            String platform = download.getPlatforms();
            BigDecimal totalDownloads = download.getTotalDownloads();

            // Check if the platform already exists in the list
            boolean exists = false;
            for (PlatformDownloads pd : platformDownloadsList) {
                if (pd.getPlatform().equals(platform)) {
                    pd.setTotalDownloads(pd.getTotalDownloads().add(totalDownloads));
                    exists = true;
                    break;
                }
            }

            // If platform does not exist, add it to the list
            if (!exists) {
                platformDownloadsList.add(new PlatformDownloads(platform, totalDownloads));
            }
        }

        return platformDownloadsList;
    }

// -------------------------------------------------------------------------------------------------------------------//

    private BigDecimal calculateTotalDownloads() {
        List<DownloadsEntity> allDownloads = downloadsRepository.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for (DownloadsEntity download : allDownloads) {
            total = total.add(download.getTotalDownloads());
        }
        return total;
    }

    private BigDecimal calculateDownloadsInPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        List<DownloadsEntity> downloadsInPeriod = downloadsRepository.findByCreatedAtBetween(startDate, endDate);
        BigDecimal total = BigDecimal.ZERO;
        for (DownloadsEntity download : downloadsInPeriod) {
            total = total.add(download.getTotalDownloads());
        }
        return total;
    }
}
