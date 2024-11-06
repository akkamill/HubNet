package com.example.ecommerceDemo.services.general.application;

import com.example.ecommerceDemo.DTO.general.application.ApplicationDTO;
import com.example.ecommerceDemo.entities.general.application.ApplicationEntity;
import com.example.ecommerceDemo.repositories.general.application.ApplicationRepository;
import com.example.ecommerceDemo.services.mappers.general.application.ApplicationMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Transactional
    public List<ApplicationDTO> getAllApplications() {

        List<ApplicationEntity> entities = applicationRepository.findAll();
        List<ApplicationDTO> dtoList = new ArrayList<>();
        for (ApplicationEntity ap : entities) {

            double averageRating = ap.calculateAverageRating();
            ApplicationDTO applicationDTO = ApplicationMappers.toApplicationDTO(ap);
            applicationDTO.setAverageRating(averageRating);

            applicationDTO.setPrice(ap.getPrice());
            applicationDTO.setPlatform(ap.getPlatform());

            dtoList.add(applicationDTO);
        }
        return dtoList;
    }

    @Transactional
    public ApplicationDTO getApplicationById(Long id) {
        ApplicationEntity applicationEntity = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        double averageRating = applicationEntity.calculateAverageRating();

        ApplicationDTO applicationDTO = ApplicationMappers.toApplicationDTO(applicationEntity);
        applicationDTO.setAverageRating(averageRating);

        return ApplicationMappers.toApplicationDTO(applicationEntity);
    }


}
