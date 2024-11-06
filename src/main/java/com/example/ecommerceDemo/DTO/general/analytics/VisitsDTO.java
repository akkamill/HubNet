package com.example.ecommerceDemo.DTO.general.analytics;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitsDTO {

    private Long visitId;
    private String visitCountry;
    private int websiteVisits;
    private LocalDateTime visitDate;
    private Long userId;

}
