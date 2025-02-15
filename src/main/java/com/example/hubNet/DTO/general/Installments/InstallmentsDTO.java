package com.example.hubNet.DTO.general.Installments;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InstallmentsDTO {

    private Long installmentId;
    private String countries;
    private String platforms;
    private String mainlands;
    private LocalDateTime createdAt;

}
