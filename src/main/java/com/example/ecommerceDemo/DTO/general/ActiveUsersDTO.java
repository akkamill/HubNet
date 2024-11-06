package com.example.ecommerceDemo.DTO.general;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActiveUsersDTO {

    private Long activeUserId;
    private LocalDateTime lastSeen;

}
