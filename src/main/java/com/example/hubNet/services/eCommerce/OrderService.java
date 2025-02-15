package com.example.hubNet.services.eCommerce;

import com.example.hubNet.DTO.eCommerce.OrderDTO;
import com.example.hubNet.DTO.others.ProcessPaymentRequest;
import com.example.hubNet.entities.eCommerce.Cart;
import com.example.hubNet.entities.eCommerce.CartItem;
import com.example.hubNet.entities.eCommerce.OrderEntity;
import com.example.hubNet.entities.eCommerce.OrderItem;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.repositories.eCommerce.CartRepository;
import com.example.hubNet.repositories.eCommerce.OrderItemRepository;
import com.example.hubNet.repositories.eCommerce.OrderRepository;
import com.example.hubNet.repositories.others.PaymentRepository;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.services.mappers.eCommerce.OrderMappers;
import com.example.hubNet.services.others.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;


    @Autowired
    public OrderService(CartRepository cartRepository,
                        OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        UserRepository userRepository,
                        PaymentService paymentService, PaymentRepository paymentRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public OrderDTO completeOrder(Long cartId, Long userId, ProcessPaymentRequest paymentRequest) {
//        ProcessPaymentRequest processPaymentRequest = orderAndPayment.getProcessPaymentRequest();

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

//        PaymentEntity paymentEntity = paymentService.processPayment(userId, paymentRequest);
//        paymentEntity.setPaymentAmount(cart.getGrandTotal());
        paymentRequest.getPaymentEntity().setPaymentAmount(cart.getGrandTotal());
        paymentService.processPayment(userId, paymentRequest);

        OrderEntity order = new OrderEntity();
        order.setTotalAmount(cart.getGrandTotal());
        order.setUser(user);

        orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(cartItem.getProductTotalPrice());

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);
//        paymentRepository.save(paymentEntity);

        OrderDTO orderDTO = OrderMappers.toDTO(order, orderItems);
        orderDTO.setOrderItems(OrderMappers.toOrderItemDTOList(orderItems));

        cartRepository.delete(cart);
        paymentService.sendPaymentConfirmationEmail(userId, user.getEmailAddress(), paymentRequest.getPaymentEntity());

//        paymentService.sendPaymentConfirmationEmail(user.getEmailAddress(), paymentEntity);

        return orderDTO;
    }




}
