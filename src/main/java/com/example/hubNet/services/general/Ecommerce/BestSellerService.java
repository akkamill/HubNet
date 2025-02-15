package com.example.hubNet.services.general.Ecommerce;

import com.example.hubNet.DTO.general.Ecommerce.BestSellerDTO;
import com.example.hubNet.entities.general.Ecommerce.BestSellerEntity;
import com.example.hubNet.repositories.general.Ecommerce.BestSellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BestSellerService {

    private final BestSellerRepository bestSellerRepository;

    public BestSellerService(BestSellerRepository bestSellerRepository) {
        this.bestSellerRepository = bestSellerRepository;
    }


    public List<BestSellerDTO> getBestSeller() {

        List<BestSellerEntity> bestSellerEntities = bestSellerRepository.findAll();

        return bestSellerEntities.stream()
                .map(this::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }



    // -------------------------------------------------------------------------------------------------------------//

    public BestSellerDTO toDTO(BestSellerEntity entity) {

        if(entity == null) {
            return null;
        }

        BestSellerDTO dto = new BestSellerDTO();

        dto.setBestSellerId(entity.getBestSellerId());
        dto.setSellerCountry(entity.getSellerCountry());
        dto.setSellerName(entity.getSellerName());
        dto.setSellerSurname(entity.getSellerSurname());
        dto.setSellerStatus(entity.getSellerStatus());
        dto.setSellerEmailAddress(entity.getSellerEmailAddress());
        dto.setTotalAmount(entity.getTotalAmount());

        return dto;
    }



}
