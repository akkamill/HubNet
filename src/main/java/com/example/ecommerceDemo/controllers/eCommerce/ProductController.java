package com.example.ecommerceDemo.controllers.eCommerce;

import com.example.ecommerceDemo.DTO.eCommerce.ProductDTO;
import com.example.ecommerceDemo.services.eCommerce.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createProduct(@PathVariable Long userId,
                                           @ModelAttribute ProductDTO productDTO,
                                           @RequestParam(value = "productImage", required = false)
                                           MultipartFile productImage) {

        try {
            ProductDTO createdProduct = productService.createProduct(userId, productDTO, productImage);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/filter")
    public List<ProductDTO> filterProducts(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false, defaultValue = "0") double minRating) {

        return productService.filterProducts(gender, category, color, minPrice, maxPrice, minRating);

    }


}
