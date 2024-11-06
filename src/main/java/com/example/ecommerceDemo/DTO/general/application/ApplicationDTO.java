package com.example.ecommerceDemo.DTO.general.application;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationDTO {

    private Long applicationId;
    private String name;
    private String platform;
    private double averageRating;
    private int price;

    private List<AppRatingsDTO> appRatings;

}