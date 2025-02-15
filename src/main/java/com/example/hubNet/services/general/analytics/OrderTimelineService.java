package com.example.hubNet.services.general.analytics;

import com.example.hubNet.DTO.general.analytics.OrderTimelineDTO;
import com.example.hubNet.entities.general.analytics.OrderTimelineEntity;
import com.example.hubNet.repositories.general.analytics.OrderTimelineRepository;
import com.example.hubNet.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderTimelineService {

    private final OrderTimelineRepository orderTimelineRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderTimelineService(OrderTimelineRepository orderTimelineRepository, UserRepository userRepository) {
        this.orderTimelineRepository = orderTimelineRepository;
        this.userRepository = userRepository;
    }


    private void getUserById(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<OrderTimelineDTO> getOrderTimelineByUserId(Long userId) {
        getUserById(userId);  // Ensure the user exists
        List<OrderTimelineEntity> orderTimelines = orderTimelineRepository.findByUserUserId(userId);
        List<OrderTimelineDTO> orderTimelineDTOs = new ArrayList<>();
        for (OrderTimelineEntity entity : orderTimelines) {
            orderTimelineDTOs.add(toDTO(entity));
        }
        return orderTimelineDTOs;
    }

//    ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------//

    public OrderTimelineDTO toDTO(OrderTimelineEntity entity) {
        OrderTimelineDTO dto = new OrderTimelineDTO();
        dto.setOrderTimelineId(entity.getOrderTimelineId());
        dto.setOrderName(entity.getOrderName());
        dto.setOrderTime(entity.getOrderTime());
        return dto;
    }

    public OrderTimelineEntity toEntity(OrderTimelineDTO dto) {
        OrderTimelineEntity entity = new OrderTimelineEntity();
        entity.setOrderTimelineId(dto.getOrderTimelineId());
        entity.setOrderName(dto.getOrderName());
        entity.setOrderTime(dto.getOrderTime());
        return entity;
    }

}
