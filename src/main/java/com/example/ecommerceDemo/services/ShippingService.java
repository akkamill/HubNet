package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.ShippingAddressDTO;
import com.example.ecommerceDemo.entities.shipping.ShippingAddress;
import com.example.ecommerceDemo.repositories.ShippingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public ShippingAddress createAddress(ShippingAddressDTO shippingAddressDTO) {

        ShippingAddress shippingAddress = toEntity(shippingAddressDTO);

        return shippingRepository.save(shippingAddress);
    }


    //---------------------------------------------------------------------------------------------------------------//


    public static ShippingAddressDTO toDTO(ShippingAddress shippingAddress) {
        ShippingAddressDTO dto = new ShippingAddressDTO();
        dto.setShippingId(shippingAddress.getShippingId());
        dto.setShippingName(shippingAddress.getShippingName());
        dto.setShippingLastName(shippingAddress.getShippingLastName());
        dto.setShippingEmail(shippingAddress.getShippingEmail());
        dto.setEmailNews(shippingAddress.isEmailNews());
        dto.setShippingAddress(shippingAddress.getShippingAddress());
        dto.setShippingDoorNo(shippingAddress.getShippingDoorNo());
        dto.setShippingCountry(shippingAddress.getShippingCountry());
        dto.setShippingCity(shippingAddress.getShippingCity());
        dto.setShippingState(shippingAddress.getShippingState());
        dto.setShippingZipCode(shippingAddress.getShippingZipCode());
        dto.setShippingMobNumber(shippingAddress.getShippingMobNumber());
        dto.setTextNews(shippingAddress.isTextNews());
        return dto;
    }

    public static ShippingAddress toEntity(ShippingAddressDTO dto) {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setShippingId(dto.getShippingId());
        shippingAddress.setShippingName(dto.getShippingName());
        shippingAddress.setShippingLastName(dto.getShippingLastName());
        shippingAddress.setShippingEmail(dto.getShippingEmail());
        shippingAddress.setEmailNews(dto.isEmailNews());
        shippingAddress.setShippingAddress(dto.getShippingAddress());
        shippingAddress.setShippingDoorNo(dto.getShippingDoorNo());
        shippingAddress.setShippingCountry(dto.getShippingCountry());
        shippingAddress.setShippingCity(dto.getShippingCity());
        shippingAddress.setShippingState(dto.getShippingState());
        shippingAddress.setShippingZipCode(dto.getShippingZipCode());
        shippingAddress.setShippingMobNumber(dto.getShippingMobNumber());
        shippingAddress.setTextNews(dto.isTextNews());
        return shippingAddress;
    }


}
