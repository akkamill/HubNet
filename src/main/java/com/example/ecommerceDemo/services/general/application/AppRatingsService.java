package com.example.ecommerceDemo.services.general.application;

import com.example.ecommerceDemo.DTO.general.application.AppRatingsDTO;
import com.example.ecommerceDemo.entities.general.application.AppRatings;
import com.example.ecommerceDemo.entities.general.application.ApplicationEntity;
import com.example.ecommerceDemo.repositories.general.application.AppRatingsRepository;
import com.example.ecommerceDemo.repositories.general.application.ApplicationRepository;
import com.example.ecommerceDemo.services.mappers.general.application.AppRatingsMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRatingsService {

    private final AppRatingsRepository appRatingsRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public AppRatingsService(AppRatingsRepository appRatingsRepository, ApplicationRepository applicationRepository) {
        this.appRatingsRepository = appRatingsRepository;
        this.applicationRepository = applicationRepository;
    }

    @Transactional
    public AppRatingsDTO createAppRating(Long applicationId, AppRatingsDTO ratingDTO) {
        ApplicationEntity application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        AppRatings appRating = AppRatingsMappers.toAppRatingsEntity(ratingDTO);
        appRating.setApplicationEntity(application);

        AppRatings savedRating = appRatingsRepository.save(appRating);

        return AppRatingsMappers.toAppRatingsDTO(savedRating);
    }


}
