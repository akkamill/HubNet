package com.example.ecommerceDemo.DTO.general.analytics;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsUpdatesDTO {

    private Long id;
    private String title;
    private String subtitle;
    private LocalDateTime createdAt;
    private Long userId;

}
