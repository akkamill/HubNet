package com.example.hubNet.services.mappers.general.application;

import com.example.hubNet.DTO.general.application.AppRatingsDTO;
import com.example.hubNet.entities.general.application.AppRatings;
import org.springframework.stereotype.Component;

@Component
public class AppRatingsMappers {


    public static AppRatings toAppRatingsEntity(AppRatingsDTO appRatingDTO) {

        AppRatings entity = new AppRatings();

        entity.setAppRatingId(appRatingDTO.getAppRatingId());
        entity.setAppReviewText(appRatingDTO.getAppReviewText());
        entity.setRate(appRatingDTO.getRate());
        entity.setRateCreatedAt(appRatingDTO.getRateCreatedAt());

        return entity;
    }


    public static AppRatingsDTO toAppRatingsDTO(AppRatings appRatings) {

        AppRatingsDTO dto = new AppRatingsDTO();

        dto.setAppRatingId(appRatings.getAppRatingId());
        dto.setAppReviewText(appRatings.getAppReviewText());
        dto.setRate(appRatings.getRate());
        dto.setRateCreatedAt(appRatings.getRateCreatedAt());

        return dto;
    }
}
