package com.example.hubNet.DTO.eCommerce;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class OrderDTO {

    private Long orderId;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;

    private List<OrderItemDTO> orderItems;

}
