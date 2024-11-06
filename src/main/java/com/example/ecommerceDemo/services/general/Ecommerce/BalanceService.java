package com.example.ecommerceDemo.services.general.Ecommerce;

import com.example.ecommerceDemo.DTO.general.Ecommerce.BalanceDTO;
import com.example.ecommerceDemo.entities.general.Ecommerce.BalanceEntity;
import com.example.ecommerceDemo.repositories.general.Ecommerce.BalanceRepository;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;


    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public BalanceDTO getBalance(Long balanceId) {

        BalanceEntity balanceEntity = balanceRepository.findById(balanceId).orElseThrow(()
                -> new RuntimeException("Balance id not found"));

        return toDTO(balanceEntity);
    }


    // -----------------------------------------------------------------------------------------------------------------//

    public BalanceDTO toDTO(BalanceEntity balanceEntity) {
        BalanceDTO dto = new BalanceDTO();
        dto.setBalanceId(balanceEntity.getBalanceId());
        dto.setTotalBalance(balanceEntity.getTotalBalance());
        dto.setSentAmount(balanceEntity.getSentAmount());
        dto.setCreatedAt(balanceEntity.getCreatedAt());
        if (balanceEntity.getUser() != null) {
            dto.setUserId(balanceEntity.getUser().getUserId());
        }
        return dto;
    }

    public BalanceEntity toEntity(BalanceDTO dto) {
        BalanceEntity entity = new BalanceEntity();
        entity.setBalanceId(dto.getBalanceId());
        entity.setTotalBalance(dto.getTotalBalance());
        entity.setSentAmount(dto.getSentAmount());
        entity.setCreatedAt(dto.getCreatedAt());

        return entity;
    }


}
