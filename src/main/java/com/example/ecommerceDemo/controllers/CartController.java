package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.CartDTO;
import com.example.ecommerceDemo.DTO.CartItemDTO;
import com.example.ecommerceDemo.entities.shipping.Cart;
import com.example.ecommerceDemo.entities.shipping.CartItem;
import com.example.ecommerceDemo.services.CartItemService;
import com.example.ecommerceDemo.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

//    @PostMapping("/create-cart")
//    public ResponseEntity<Cart> createCart(@RequestBody CartDTO cartDTO) {
//        String discountCode = cartDTO.getDiscountCode();
//        List<CartItemDTO> cartItemDTOs = cartDTO.getCartItems();
//
//        // Convert CartItemDTOs to CartItems
//        List<CartItem> cartItems = cartItemDTOs.stream()
//                .map(cartItemDTO -> cartItemService.createCartItem(cartItemDTO))
//                .collect(Collectors.toList());
//
//        Cart createdCart = cartService.createCart(discountCode, cartItems);
//        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
//    }

//    @PostMapping("/apply-discount/{cartId}")
//    public ResponseEntity<CartDTO> applyDiscount(@PathVariable Long cartId,
//                                                 @RequestParam String discountCode) {
//        Cart cart = cartService.applyDiscount(cartId, discountCode);
//        CartDTO cartDTO = cartService.toDTO(cart);
//        return ResponseEntity.ok().body(cartDTO);
//    }

    @PostMapping("/{cartId}/apply-discount")
    public ResponseEntity<String> applyDiscountToCart(@PathVariable Long cartId, @RequestParam String discountCode) {
        try {
            cartService.applyDiscountToCart(cartId, discountCode);
            return ResponseEntity.ok("Discount applied successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/get-cart/{cartId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.getCart(cartId));
    }



}
