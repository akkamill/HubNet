package com.example.hubNet.services.general.analytics;

import com.example.hubNet.DTO.general.analytics.ConversionDTO;
import com.example.hubNet.entities.general.analytics.ConversionEntity;
import com.example.hubNet.repositories.general.analytics.ConversionRepository;
import com.example.hubNet.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversionService {

    private final ConversionRepository conversionRepository;
    private final UserRepository userRepository;

    public ConversionService(ConversionRepository conversionRepository, UserRepository userRepository) {
        this.conversionRepository = conversionRepository;
        this.userRepository = userRepository;
    }


    private void getUserById(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<ConversionDTO> getConversionsByUserId(Long userId) {
        getUserById(userId);  // Ensure the user exists
        List<ConversionEntity> conversions = conversionRepository.findByUserUserId(userId);
        List<ConversionDTO> conversionDTOs = new ArrayList<>();
        for (ConversionEntity entity : conversions) {
            conversionDTOs.add(toDTO(entity));
        }
        return conversionDTOs;
    }



    // --------------------------------------------------------------------------------------------------------------//

    public ConversionDTO toDTO(ConversionEntity entity) {
        ConversionDTO dto = new ConversionDTO();
        dto.setConversionId(entity.getConversionId());
        dto.setConversionRates(entity.getConversionRates());
        dto.setConversionDate(entity.getConversionDate());
        dto.setUserId(entity.getUser().getUserId());  // Assuming UserEntity has userId field
        return dto;
    }

    public ConversionEntity toEntity(ConversionDTO dto) {
        ConversionEntity entity = new ConversionEntity();
        entity.setConversionId(dto.getConversionId());
        entity.setConversionRates(dto.getConversionRates());
        entity.setConversionDate(dto.getConversionDate());
        // Assuming UserEntity is already fetched using userId
        return entity;
    }
}
