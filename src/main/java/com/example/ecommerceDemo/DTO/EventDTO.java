package com.example.ecommerceDemo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDTO {

    private Long eventId;

    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
