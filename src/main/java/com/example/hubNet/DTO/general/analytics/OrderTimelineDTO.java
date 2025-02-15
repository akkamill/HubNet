package com.example.hubNet.DTO.general.analytics;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderTimelineDTO {

    private Long orderTimelineId;
    private String orderName;
    private LocalDateTime orderTime;
    private Long userId;

}
