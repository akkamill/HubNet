package com.example.hubNet.services.mappers.eCommerce;

import com.example.hubNet.DTO.eCommerce.OrderDTO;
import com.example.hubNet.DTO.eCommerce.OrderItemDTO;
import com.example.hubNet.entities.eCommerce.OrderEntity;
import com.example.hubNet.entities.eCommerce.OrderItem;
import com.example.hubNet.repositories.eCommerce.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMappers {

    private static ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        OrderMappers.productRepository = productRepository;
    }

    // Convert OrderDTO to OrderEntity
    public static OrderEntity toEntity(OrderDTO orderDTO) {

        OrderEntity orderEntity = new OrderEntity();


        orderEntity.setOrderId(orderDTO.getOrderId());
        orderEntity.setOrderDate(orderDTO.getOrderDate());
        orderEntity.setTotalAmount(orderDTO.getTotalAmount());

        // Convert List<OrderItemDTO> to List<OrderItem> without using streams
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            orderItems.add(toOrderItemEntity(orderItemDTO));
        }
        orderEntity.setOrderItems(orderItems);

        return orderEntity;
    }

    // Convert OrderItemDTO to OrderItem
    private static OrderItem toOrderItemEntity(OrderItemDTO orderItemDTO) {
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

    // Convert OrderEntity to OrderDTO
    public static OrderDTO toDTO(OrderEntity orderEntity, List<OrderItem> orderItems) {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderId(orderEntity.getOrderId());
        orderDTO.setOrderDate(orderEntity.getOrderDate());
        orderDTO.setTotalAmount(orderEntity.getTotalAmount());

        // Convert List<OrderItem> to List<OrderItemDTO> without using streams
        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        for (OrderItem orderItem : orderEntity.getOrderItems()) {
            orderItemDTOs.add(toOrderItemDTO(orderItem));
        }
        orderDTO.setOrderItems(orderItemDTOs);

        return orderDTO;
    }

    // Convert OrderItem to OrderItemDTO
    private static OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
        orderItemDTO.setProductName(orderItem.getProduct().getProductName()); // Ensure product is not null
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
        return orderItemDTO;
    }

    public static List<OrderItemDTO> toOrderItemDTOList(List<OrderItem> orderItems) {
        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            orderItemDTOs.add(toOrderItemDTO(orderItem));
        }
        return orderItemDTOs;
    }
}
