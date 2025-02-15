package com.example.hubNet.services.eCommerce;

import com.example.hubNet.DTO.eCommerce.DeliveryDTO;
import com.example.hubNet.entities.eCommerce.DeliveryEntity;
import com.example.hubNet.entities.eCommerce.Cart;
import com.example.hubNet.entities.eCommerce.enums.DeliveryType;
import com.example.hubNet.repositories.eCommerce.CartRepository;
import com.example.hubNet.repositories.eCommerce.DeliveryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final CartRepository cartRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, CartRepository cartRepository) {
        this.deliveryRepository = deliveryRepository;
        this.cartRepository = cartRepository;
    }

//    @Transactional
//    public void deliveryPrice(Long cartId, DeliveryDTO deliveryDTO) {
//
//        Cart cart = cartRepository.findById(cartId).orElseThrow(() ->
//                new RuntimeException("Cart not found"));
//
//        if (deliveryDTO.getDeliveryType() == DeliveryType.FAST) {
//
//            BigDecimal grandTotal = cart.getGrandTotal().add(new BigDecimal(10));
//
//            cart.setGrandTotal(grandTotal);
//            cartRepository.save(cart);
//        } else if (deliveryDTO.setDeliveryType() == DeliveryType.STANDARD) {
//            BigDecimal grandTotal = cart.getGrandTotal().add(new BigDecimal(0));
//        }

//    @Transactional
//    public void deliveryPrice(Long cartId, DeliveryType deliveryType) {
//
//        Cart cart = cartRepository.findById(cartId).orElseThrow(() ->
//                new RuntimeException("Cart not found"));
//
//        DeliveryEntity deliveryEntity = deliveryRepository.findByCart(cart)
//                .orElse(new DeliveryEntity());
//
//        BigDecimal deliveryCost = BigDecimal.ZERO;
//        switch (deliveryType) {
//            case FAST:
//                deliveryCost = new BigDecimal(10); // Set delivery cost for FAST delivery
//                break;
//            case STANDARD:
//                deliveryCost = BigDecimal.ZERO; // Set delivery cost for STANDARD delivery
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported delivery type: " + deliveryType);
//        }
//
//        // Update the delivery entity with the new delivery type and cost
//        deliveryEntity.setDeliveryType(deliveryType);
//        deliveryEntity.setDeliveryCost(deliveryCost);
//        deliveryEntity.setCart(cart);
//
//        deliveryRepository.save(deliveryEntity);
//        cart.setGrandTotal(cart.getGrandTotal().add(deliveryCost));
//        cartRepository.save(cart);
//    }

    @Transactional
    public void deliveryPrice(Long cartId, DeliveryType deliveryType) {
        // Retrieve the cart
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Retrieve or create a delivery entity for the cart
        DeliveryEntity deliveryEntity = cart.getDeliveryEntity();
        if (deliveryEntity == null) {
            deliveryEntity = new DeliveryEntity();
            deliveryEntity.setCart(cart);
        }

        // Calculate the delivery cost based on the chosen delivery type
        BigDecimal deliveryCost = calculateDeliveryCost(deliveryType);

        // Update the delivery type and cost in the delivery entity
        deliveryEntity.setDeliveryType(deliveryType);
        deliveryEntity.setDeliveryCost(deliveryCost);

        // Save the updated delivery entity
        deliveryRepository.save(deliveryEntity);

        // Update the grand total of the cart
        BigDecimal newGrandTotal = cart.getSubTotal().add(deliveryCost);
        cart.setGrandTotal(newGrandTotal);

        // Save the updated cart
        cartRepository.save(cart);
    }


    //---------------------------------------------------------------------------------------------------------------//


    private BigDecimal calculateDeliveryCost(DeliveryType deliveryType) {
        // Calculate the delivery cost based on the chosen delivery type
        switch (deliveryType) {
            case FAST:
                return new BigDecimal(10);
            case STANDARD:
                return BigDecimal.ZERO;
            default:
                throw new IllegalArgumentException("Unsupported delivery type: " + deliveryType);
        }
    }


    public DeliveryDTO toDTO(DeliveryEntity deliveryEntity) {
        DeliveryDTO dto = new DeliveryDTO();
        dto.setDeliveryId(deliveryEntity.getDeliveryId());
        dto.setDeliveryType(deliveryEntity.getDeliveryType());
        dto.setDeliveryCost(deliveryEntity.getDeliveryCost());
        // Set other fields as needed
        return dto;
    }

    public DeliveryEntity toEntity(DeliveryDTO dto) {
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setDeliveryId(dto.getDeliveryId());
        deliveryEntity.setDeliveryType(dto.getDeliveryType());
        deliveryEntity.setDeliveryCost(dto.getDeliveryCost());
        // Set other fields as needed
        return deliveryEntity;
    }


}
