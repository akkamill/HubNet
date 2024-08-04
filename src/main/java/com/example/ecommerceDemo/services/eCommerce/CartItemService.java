package com.example.ecommerceDemo.services.eCommerce;

import com.example.ecommerceDemo.DTO.eCommerce.CartItemDTO;
import com.example.ecommerceDemo.entities.eCommerce.ProductEntity;
import com.example.ecommerceDemo.entities.eCommerce.Cart;
import com.example.ecommerceDemo.entities.eCommerce.CartItem;
import com.example.ecommerceDemo.repositories.eCommerce.CartItemRepository;
import com.example.ecommerceDemo.repositories.eCommerce.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CartService cartService;

    public CartItemService(CartItemRepository cartItemRepository, ProductRepository productRepository, CartService cartService) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.cartService = cartService;
    }

//    public CartItem createCartItem(CartItemDTO cartItemDTO, Cart cart) {
//        // Retrieve the product entity from the repository
//        ProductEntity productEntity = productRepository.findById(cartItemDTO.getProductId())
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//        // Create a new CartItem entity and set the Cart reference
//        CartItem cartItem = new CartItem(cart, productEntity, cartItemDTO.getQuantity(), calculateTotalPrice(cartItemDTO));
//
//        // Save the CartItem entity
//        cartItemRepository.save(cartItem);
//
//        return cartItem;
//    }

    public CartItem createCartItem(CartItemDTO cartItemDTO, Long cartId) {
        // Retrieve the product entity from the repository
        ProductEntity productEntity = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(productEntity);
        cartItem.setQuantity(cartItemDTO.getQuantity());

        // Calculate and set the total price for the cart item
        BigDecimal productTotalPrice = calculateTotalPrice(cartItemDTO);
        cartItem.setProductTotalPrice(productTotalPrice);


        // Fetch the cart or create a new one if it doesn't exist
        Cart cart = cartService.getOrCreateCart(cartId, Collections.singletonList(cartItem));
        cartItem.setCart(cart);

        return cartItemRepository.save(cartItem);
    }




    public CartItemDTO getCartItem(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() ->
                new RuntimeException("Cart item not found"));

        return toDTO(cartItem);

    }

    public BigDecimal calculateTotalPrice(CartItemDTO cartItemDTO) {
        // Retrieve the product entity from the repository
        ProductEntity productEntity = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Calculate the total price based on the product's price and quantity
        BigDecimal productTotalPrice = productEntity.getProductSalePrice()
                .multiply(BigDecimal.valueOf(cartItemDTO.getQuantity()));


        return productTotalPrice;
    }



    //-----------------------------------------------------------------------------------------------------------//

    private CartItemDTO toDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setCartItemId(cartItem.getCartItemId());
        cartItemDTO.setProductId(cartItem.getProduct().getProductId());
        cartItemDTO.setProductName(cartItem.getProduct().getProductName());
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setProductTotalPrice(cartItem.getProductTotalPrice());

        return cartItemDTO;
    }


}
