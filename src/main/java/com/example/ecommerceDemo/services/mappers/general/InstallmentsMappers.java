//package com.example.ecommerceDemo.services.mappers.general;
//
//import com.example.ecommerceDemo.DTO.general.Installments.InstallmentsDTO;
//import com.example.ecommerceDemo.entities.general.InstallmentsEntity;
//import org.springframework.stereotype.Component;
//
//@Component
//public class InstallmentsMappers {
//
//    public static InstallmentsDTO toDTO(InstallmentsEntity entity) {
//        if (entity == null) {
//            return null;
//        }
//
//        InstallmentsDTO dto = new InstallmentsDTO();
//
//        dto.setInstallmentId(entity.getInstallmentId());
//        dto.setCountries(entity.getCountries());
//        dto.setPlatforms(entity.getPlatforms());
//        dto.setMainlands(entity.getMainlands());
//        dto.setCreatedAt(entity.getCreatedAt());
//
//        return dto;
//    }
//
//    public static InstallmentsEntity toEntity(InstallmentsDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//
//        InstallmentsEntity entity = new InstallmentsEntity();
//
//        entity.setInstallmentId(dto.getInstallmentId());
//        entity.setCountries(dto.getCountries());
//        entity.setPlatforms(dto.getPlatforms());
//        entity.setMainlands(dto.getMainlands());
//        entity.setCreatedAt(dto.getCreatedAt());
//
//        return entity;
//    }
//}
