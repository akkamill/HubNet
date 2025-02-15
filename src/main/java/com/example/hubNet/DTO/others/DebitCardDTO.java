package com.example.hubNet.DTO.others;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DebitCardDTO {

    private Long id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expirationDate;
    private int cvv;


//    private UserEntity user;


}
