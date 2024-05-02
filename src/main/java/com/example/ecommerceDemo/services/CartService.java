package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.CartDTO;
import com.example.ecommerceDemo.entities.shipping.Cart;
import com.example.ecommerceDemo.entities.shipping.CartItem;
import com.example.ecommerceDemo.entities.shipping.DiscountCodes;
import com.example.ecommerceDemo.repositories.CartRepository;
import com.example.ecommerceDemo.repositories.DiscountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final DiscountRepository discountRepository;


    public CartService(CartRepository cartRepository, DiscountRepository discountRepository) {
        this.cartRepository = cartRepository;
        this.discountRepository = discountRepository;
    }


    @Transactional
    public void applyDiscountToCart(Long cartId, String discountCode) {
        // Retrieve the cart from the repository
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Retrieve the discount code entity from the repository
        DiscountCodes discount = discountRepository.findByDiscountCode(discountCode);

        // Apply the discount code to the cart
        cart.setAppliedDiscountCode(discount);


        // Recalculate the cart's grand total
        BigDecimal grandTotal = calculateGrandTotal(cart);
        cart.setDiscountPrice(discount.getDiscountAmount());
        cart.setGrandTotal(grandTotal);

        // Save the updated cart
        cartRepository.save(cart);
    }


    public CartDTO getCart(Long cartId) {
    // Retrieve the cart from the repository
    Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

    // Calculate the cart's grand total
    BigDecimal grandTotal = calculateGrandTotal(cart);

    // Create and return a CartDTO
    CartDTO cartDTO = new CartDTO();
    cartDTO.setCartId(cart.getCartId());
    cartDTO.setSubTotal(cart.getSubTotal());
    cartDTO.setGrandTotal(grandTotal);
    cartDTO.setDiscountPrice(cart.getDiscountPrice());

    return cartDTO;
}
    @Transactional
    public Cart getOrCreateCart(Long cartId, List<CartItem> cartItems) {
        if (cartId != null) {
            // If cartId is provided, fetch the existing cart
            return cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
        } else {
            // If cartId is not provided, create a new cart
            Cart cart = new Cart();

            // Check if cartItems is not null and not empty before setting it
            if (cartItems != null && !cartItems.isEmpty()) {
                cart.setCartItems(cartItems);

                // Calculate subtotal
                BigDecimal totalPrice = BigDecimal.ZERO;
                for (CartItem cartItem : cartItems) {
                    BigDecimal productTotalPrice = cartItem.getProductTotalPrice();
                    if (productTotalPrice != null) {
                        totalPrice = totalPrice.add(productTotalPrice);
                    }
                }
                cart.setSubTotal(totalPrice);
            }

            // Save the new cart
            return cartRepository.save(cart);
        }
    }



    //---------------------------------------------------------------------------------------------------------------//


    private BigDecimal calculateGrandTotal(Cart cart) {
        // Calculate the total price of all cart items
        BigDecimal totalCartPrice = cart.getSubTotal();

        // Apply discount if a discount code is applied
        if (cart.getAppliedDiscountCode() != null) {
            BigDecimal discountAmount = cart.getAppliedDiscountCode().getDiscountAmount();
            totalCartPrice = totalCartPrice.subtract(discountAmount);
        }

        return totalCartPrice;
    }

    public CartDTO toDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setSubTotal(cart.getSubTotal());
        cartDTO.setGrandTotal(cart.getGrandTotal());
        cartDTO.setDiscountPrice(cart.getDiscountPrice());

        return cartDTO;
    }

    public Cart toEntity(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart.setSubTotal(cartDTO.getSubTotal());
        cart.setGrandTotal(cartDTO.getGrandTotal());
        cart.setDiscountPrice(cartDTO.getDiscountPrice());

        return cart;
    }

}
