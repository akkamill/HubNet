package com.example.ecommerceDemo.DTO.others;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
