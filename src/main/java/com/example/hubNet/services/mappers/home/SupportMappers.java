package com.example.hubNet.services.mappers.home;

import com.example.hubNet.DTO.home.SupportDTO;
import com.example.hubNet.entities.home.SupportEntity;
import org.springframework.stereotype.Component;

@Component
public class SupportMappers {

    public static SupportDTO toDTO(SupportEntity entity) {
        SupportDTO dto = new SupportDTO();

        dto.setSupportId(entity.getSupportId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setSubject(entity.getSubject());
        dto.setMessage(entity.getMessage());

        return dto;
    }

    public static SupportEntity toEntity(SupportDTO dto) {
        SupportEntity entity = new SupportEntity();

        entity.setSupportId(dto.getSupportId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setSubject(dto.getSubject());
        entity.setMessage(dto.getMessage());

        return entity;
    }
}
