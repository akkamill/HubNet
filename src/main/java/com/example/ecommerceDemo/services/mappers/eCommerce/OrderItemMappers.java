package com.example.ecommerceDemo.services.mappers.eCommerce;

import com.example.ecommerceDemo.DTO.eCommerce.OrderItemDTO;
import com.example.ecommerceDemo.entities.eCommerce.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMappers {


    public static OrderItem toEntity(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(orderItemDTO.getOrderItemId());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setTotalPrice(orderItemDTO.getTotalPrice());

        // Fetch the ProductEntity by ID if necessary
        // ProductEntity productEntity = productRepository.findById(orderItemDTO.getProductId())
        //         .orElseThrow(() -> new RuntimeException("Product not found")); // Adjust as needed
        // orderItem.setProduct(productEntity);

        return orderItem;
    }

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
        orderItemDTO.setProductName(orderItem.getProduct().getProductName()); // Ensure product is not null
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
        return orderItemDTO;
    }
}
