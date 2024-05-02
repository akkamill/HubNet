package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.ProductDTO;
import com.example.ecommerceDemo.DTO.ReviewDTO;
import com.example.ecommerceDemo.entities.ProductEntity;
import com.example.ecommerceDemo.entities.ReviewEntity;
import com.example.ecommerceDemo.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO, MultipartFile productImage) throws IOException {

        ProductEntity productEntity = toEntity(productDTO);

        // Handle profile photo upload
        if (productImage != null && !productImage.isEmpty()) {
            // Define the directory to save profile photos
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommerceDemo\\src\\main\\resources\\productPhotos\\";

            // Create the directory if it doesn't exist
            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Define the file path
            String filePath = uploadDir + productEntity.getProductId() + "_" + productImage.getOriginalFilename();

            // Save the file to the server
            Path profilePhotoPath = Paths.get(filePath);
            Files.write(profilePhotoPath, productImage.getBytes());

            // Set the profile photo path in the user entity
            productEntity.setProductImagePath(filePath);
        }

        // Save the user entity to the database
        productRepository.save(productEntity);

        // Map the updated entity back to DTO
        return toDTO(productEntity);

    }

    @Transactional
    public List<ProductDTO> getAllProducts() {

        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity p : entities) {

            double averageRating = p.calculateAverageRating();
            ProductDTO productDTO = toDTO(p);
            productDTO.setAverageRating(averageRating);

            dtoList.add(productDTO);
        }
        return dtoList;
    }

    @Transactional
    public ProductDTO getProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found"));

        double averageRating = productEntity.calculateAverageRating();

        ProductDTO productDTO = toDTO(productEntity);
        productDTO.setAverageRating(averageRating);

        return productDTO;


    }

    // ---------------------------------------------------------------------------------------------------------------//

    public ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductId(productDTO.getProductId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setProductDescription(productDTO.getProductDescription());
        productEntity.setProductCategory(productDTO.getProductCategory());
        productEntity.setProductRegularPrice(productDTO.getProductRegularPrice());
        productEntity.setProductSalePrice(productDTO.getProductSalePrice());
        productEntity.setProductInStock(productDTO.getProductInStock());
        productEntity.setProductColor(productDTO.getProductColor());
        productEntity.setProductGender(productDTO.getProductGender());
        productEntity.setProductSize(productDTO.getProductSize());
        productEntity.setProductImagePath(productDTO.getProductImagePath());
        productEntity.setProductCreatedAt(productDTO.getProductCreatedAt());

        if (productDTO.getReviews() != null) {
            List<ReviewEntity> reviewEntities = productDTO.getReviews().stream()
                    .map(reviewDTO -> {
                        ReviewEntity reviewEntity = new ReviewEntity();
                        reviewEntity.setRate(reviewDTO.getRate());
                        reviewEntity.setReviewText(reviewDTO.getReviewText());
                        reviewEntity.setReviewName(reviewDTO.getReviewName());
                        reviewEntity.setReviewEmail(reviewDTO.getReviewEmail());
                        reviewEntity.setProduct(productEntity);
                        return reviewEntity;
                    })
                    .collect(Collectors.toList());
            productEntity.setReviews(reviewEntities);
        }

        return productEntity;
    }


    public ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setProductDescription(productEntity.getProductDescription());
        productDTO.setProductCategory(productEntity.getProductCategory());
        productDTO.setProductRegularPrice(productEntity.getProductRegularPrice());
        productDTO.setProductSalePrice(productEntity.getProductSalePrice());
        productDTO.setProductInStock(productEntity.getProductInStock());
        productDTO.setProductColor(productEntity.getProductColor());
        productDTO.setProductGender(productEntity.getProductGender());
        productDTO.setProductSize(productEntity.getProductSize());
        productDTO.setProductImagePath(productEntity.getProductImagePath());
        productDTO.setProductCreatedAt(productEntity.getProductCreatedAt());

        if (productEntity.getReviews() != null) {
            List<ReviewDTO> reviewDTOs = productEntity.getReviews().stream()
                    .map(reviewEntity -> {
                        ReviewDTO reviewDTO = new ReviewDTO();
                        reviewDTO.setRate(reviewEntity.getRate());
                        reviewDTO.setReviewText(reviewEntity.getReviewText());
                        reviewDTO.setReviewName(reviewEntity.getReviewName());
                        reviewDTO.setReviewEmail(reviewEntity.getReviewEmail());
                        return reviewDTO;
                    })
                    .collect(Collectors.toList());
            productDTO.setReviews(reviewDTOs);
        }

        return productDTO;
    }

}
