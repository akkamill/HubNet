package com.example.ecommerceDemo.DTO.general.application;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppRatingsDTO {

    private Long appRatingId;
    private String appReviewText;
    private int rate;

    private LocalDateTime rateCreatedAt;

}