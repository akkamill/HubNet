package com.example.hubNet.services.general.Ecommerce;

import com.example.hubNet.DTO.general.Ecommerce.BalanceDTO;
import com.example.hubNet.entities.general.Ecommerce.BalanceEntity;
import com.example.hubNet.repositories.general.Ecommerce.BalanceRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bankingBalanceRepository")
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
