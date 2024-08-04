package com.example.ecommerceDemo.controllers.eCommerce;

import com.example.ecommerceDemo.DTO.eCommerce.OrderDTO;
import com.example.ecommerceDemo.DTO.others.ProcessPaymentRequest;
import com.example.ecommerceDemo.services.eCommerce.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/complete/{cartId}/{userId}")
    public ResponseEntity<OrderDTO> completeOrder(
            @PathVariable Long cartId,
            @PathVariable Long userId,
            @RequestBody ProcessPaymentRequest paymentRequest) {

        logger.debug("Received paymentRequest: {}", paymentRequest);

        try {
            OrderDTO orderDTO = orderService.completeOrder(cartId, userId, paymentRequest);
            return ResponseEntity.ok(orderDTO);
        } catch (Exception e) {
            logger.error("Error completing order", e);
            return ResponseEntity.badRequest().body(null);
        }
    }
}
