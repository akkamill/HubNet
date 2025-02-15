package com.example.hubNet.DTO.general.banking;

import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.enums.Status;
import com.example.hubNet.enums.TransactionSide;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransitionsDTO {


    private Long transitionId;
    private String name;
    private BigDecimal amount;
    private TransactionSide paymentSide;
    private Status paymentStatus;
    private LocalDate processTime;
    private UserEntity user;

}
