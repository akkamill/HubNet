package com.example.ecommerceDemo.services.mappers.home;

import com.example.ecommerceDemo.DTO.home.AppPurchaseDTO;
import com.example.ecommerceDemo.entities.home.AppPurchaseEntity;
import com.example.ecommerceDemo.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

@Component
public class AppPurchaseMappers {


    public static AppPurchaseDTO toDTO(AppPurchaseEntity entity) {

        AppPurchaseDTO dto = new AppPurchaseDTO();

        dto.setPurchaseId(entity.getPurchaseId());
        dto.setPurchaseType(entity.getPurchaseType());
        dto.setYearly(entity.isYearly());
        dto.setUserDTO(UserMappers.toDTO(entity.getUserEntity()));

        return dto;
    }

    public static AppPurchaseEntity toEntity(AppPurchaseDTO dto) {

        AppPurchaseEntity entity = new AppPurchaseEntity();

        entity.setPurchaseId(dto.getPurchaseId());
        entity.setPurchaseType(dto.getPurchaseType());
        entity.setYearly(dto.isYearly());
        entity.setUserEntity(UserMappers.toEntity(dto.getUserDTO()));

        return entity;
    }


}
