package com.example.ecommerceDemo.DTO.general.banking;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.enums.Status;
import com.example.ecommerceDemo.enums.TransactionSide;
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
