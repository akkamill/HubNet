package com.example.hubNet.services.mappers.general.application;

import com.example.hubNet.DTO.general.application.AppRatingsDTO;
import com.example.hubNet.DTO.general.application.ApplicationDTO;
import com.example.hubNet.entities.general.application.ApplicationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationMappers {


    public static ApplicationEntity toApplicationEntity(ApplicationDTO applicationDTO) {
        ApplicationEntity entity = new ApplicationEntity();
        entity.setApplicationId(applicationDTO.getApplicationId());
        entity.setName(applicationDTO.getName());
        entity.setPlatform(applicationDTO.getPlatform());
        entity.setPrice(applicationDTO.getPrice());

        return entity;
    }

    public static ApplicationDTO toApplicationDTO(ApplicationEntity applicationEntity) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setApplicationId(applicationEntity.getApplicationId());
        dto.setName(applicationEntity.getName());
        dto.setPlatform(applicationEntity.getPlatform());
        dto.setPrice(applicationEntity.getPrice());

        List<AppRatingsDTO> appRatings = applicationEntity.getAppRatings()
                .stream()
                .map(AppRatingsMappers::toAppRatingsDTO)
                .collect(Collectors.toList());
        dto.setAppRatings(appRatings);

        return dto;
    }


}
