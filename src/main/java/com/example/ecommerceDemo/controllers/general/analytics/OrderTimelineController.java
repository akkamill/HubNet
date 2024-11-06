package com.example.ecommerceDemo.controllers.general.analytics;


import com.example.ecommerceDemo.DTO.general.analytics.OrderTimelineDTO;
import com.example.ecommerceDemo.services.general.analytics.OrderTimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-timeline")
public class OrderTimelineController {

    private final OrderTimelineService orderTimelineService;

    @Autowired
    public OrderTimelineController(OrderTimelineService orderTimelineService) {
        this.orderTimelineService = orderTimelineService;
    }

    // Endpoint to get all order timelines for a specific user by userId
    @GetMapping("/{userId}")
    public List<OrderTimelineDTO> getOrderTimeline(@PathVariable Long userId) {
        return orderTimelineService.getOrderTimelineByUserId(userId);  // Pass userId to the service method
    }
}