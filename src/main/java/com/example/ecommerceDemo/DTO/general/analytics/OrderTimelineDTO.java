package com.example.ecommerceDemo.DTO.general.analytics;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderTimelineDTO {

    private Long orderTimelineId;
    private String orderName;
    private LocalDateTime orderTime;
    private Long userId;

}
