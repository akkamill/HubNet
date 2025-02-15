package com.example.hubNet.DTO.general.banking;

import com.example.hubNet.entities.user.UserEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransferDTO {

    private Long transferId;
    private BigDecimal insertAmount;
    private Long senderId;
    private Long receiverId;
    private LocalDateTime createdAt;
    private UserEntity user;

}
