package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.CartItemDTO;
import com.example.ecommerceDemo.entities.shipping.Cart;
import com.example.ecommerceDemo.entities.shipping.CartItem;
import com.example.ecommerceDemo.services.CartItemService;
import com.example.ecommerceDemo.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;
    private final CartService cartService;

    public CartItemController(CartItemService cartItemService, CartService cartService) {
        this.cartItemService = cartItemService;
        this.cartService = cartService;
    }


//    @PostMapping("/create-cart-item")
//    public ResponseEntity<CartItemDTO> createCartItem(@RequestBody CartItemDTO cartItemDTO, @RequestParam Long cartId) {
//        // Fetch the corresponding cart
//        Cart cart = cartService.getCart(cartId);
//
//        // Create the cart item and associate it with the cart
//        CartItem createdCartItem = cartItemService.createCartItem(cartItemDTO, cart);
//
//        // Convert the created cart item to DTO
//        CartItemDTO createdCartItemDTO = cartItemService.convertToDTO(createdCartItem);
//
//        return new ResponseEntity<>(createdCartItemDTO, HttpStatus.CREATED);
//    }


    @PostMapping("/create-cart-item")
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItemDTO cartItemDTO,
                                                   @RequestParam(required = false) Long cartId) {
      CartItem cartItem = cartItemService.createCartItem(cartItemDTO, cartId);
        return ResponseEntity.ok(cartItem);
    }

//    @PostMapping("/create-cart-item")
//    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItemDTO cartItemDTO, @RequestParam(required = false) Long cartId) {
//
//        // Fetch or create the cart
//        Cart cart = cartService.getOrCreateCart(cartId, Collections.singletonList(cartItemDTO));
//
//        // Create the cart item
//        CartItem cartItem = cartItemService.createCartItem(cartItemDTO, cart.getCartId());
//
//        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
//    }




    @GetMapping("/get-cart-item/{cartItemId}")
    public ResponseEntity<CartItemDTO> getCartItem(@PathVariable Long cartItemId) {

        return ResponseEntity.ok(cartItemService.getCartItem(cartItemId));
    }
}
