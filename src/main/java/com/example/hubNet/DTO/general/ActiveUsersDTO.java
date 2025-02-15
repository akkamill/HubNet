package com.example.hubNet.DTO.general;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActiveUsersDTO {

    private Long activeUserId;
    private LocalDateTime lastSeen;

}
