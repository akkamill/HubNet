package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.ProductDTO;
import com.example.ecommerceDemo.DTO.UserDTO;
import com.example.ecommerceDemo.services.ProductService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@ModelAttribute ProductDTO productDTO,
                                                    @RequestParam(value = "productImage", required = false)
                                                    MultipartFile productImage) {

            try {
                ProductDTO createdProduct = productService.createProduct(productDTO, productImage);
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


}
