package com.example.hubNet.controllers.eCommerce;

import com.example.hubNet.DTO.eCommerce.CartDTO;
import com.example.hubNet.services.eCommerce.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
