package com.example.hubNet.services.eCommerce;

import com.example.hubNet.DTO.eCommerce.ProductDTO;
import com.example.hubNet.entities.eCommerce.ProductEntity;
import com.example.hubNet.entities.eCommerce.enums.ProductSaleStatus;
import com.example.hubNet.entities.eCommerce.enums.ProductStatus;
import com.example.hubNet.entities.eCommerce.enums.ProductStockStatus;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.repositories.eCommerce.ProductRepository;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.services.mappers.eCommerce.ProductMappers;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ProductDTO createProduct(Long userId, ProductDTO productDTO, MultipartFile productImage) throws IOException {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found " + userId));

        ProductEntity productEntity = ProductMappers.toEntity(productDTO);

        // Handle profile photo upload
        if (productImage != null && !productImage.isEmpty()) {
            // Define the directory to save profile photos
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\productPhotos\\";

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

        productEntity.setProductUser(user);
        if (productDTO.getProductSalePrice() != null && productEntity.getProductSalePrice().compareTo(BigDecimal.ZERO) > 0) {
            productEntity.setProductSaleStatus(ProductSaleStatus.SALE);
        }

        updateStockStatus(productEntity);

        // Save the user entity to the database
        productRepository.save(productEntity);
        updateProductStatus(productEntity);

        // Map the updated entity back to DTO
        return ProductMappers.toDTO(productEntity);

    }

    @Transactional
    public List<ProductDTO> getAllProducts() {

        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity p : entities) {

            double averageRating = p.calculateAverageRating();
            ProductDTO productDTO = ProductMappers.toDTO(p);
            productDTO.setAverageRating(averageRating);

            productDTO.setProductStockStatus(p.getProductStockStatus());
            productDTO.setProductStatus(p.getProductStatus());
            productDTO.setProductSaleStatus(p.getProductSaleStatus());

            dtoList.add(productDTO);
        }
        return dtoList;
    }

    @Transactional
    public ProductDTO getProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found"));

        double averageRating = productEntity.calculateAverageRating();

        ProductDTO productDTO = ProductMappers.toDTO(productEntity);
        productDTO.setAverageRating(averageRating);

        productDTO.setProductStockStatus(productEntity.getProductStockStatus());
        productDTO.setProductStatus(productEntity.getProductStatus());
        productDTO.setProductSaleStatus(productEntity.getProductSaleStatus());

        return productDTO;

    }

    @PostLoad
    @PostPersist
    public void updateStockStatus(ProductEntity productEntity) {

        if (productEntity.getProductInStock() != null && productEntity.getProductInStock() <= 5) {
            productEntity.setProductStockStatus(ProductStockStatus.LOW_STOCK);
        } else if (productEntity.getProductInStock() != null && productEntity.getProductInStock() > 5) {
            productEntity.setProductStockStatus(ProductStockStatus.IN_STOCK);
        }
        if (productEntity.getProductInStock() != null && productEntity.getProductInStock() == 0) {
            productEntity.setProductStockStatus(ProductStockStatus.OUT_OF_STOCK);
        }
    }


    @PostLoad
    @PostPersist
    public void updateProductStatus(ProductEntity productEntity) {

        if (productEntity.getProductCreatedAt() != null && productEntity.getProductCreatedAt().isAfter(LocalDateTime.now().minusWeeks(1))) {
            productEntity.setProductStatus(ProductStatus.NEW_ARRIVAL);
        }
    }

    @Transactional
    public List<ProductDTO> filterProducts(String gender, String category, String color, BigDecimal minPrice, BigDecimal maxPrice, double minRating) {
        List<ProductEntity> entities = productRepository.findAll();
        List<ProductEntity> filteredProducts = new ArrayList<>(entities);

        if (gender != null && !gender.isEmpty()) {
            filteredProducts = filterByGender(filteredProducts, gender);
        }
        if (category != null && !category.isEmpty()) {
            filteredProducts = filterByCategory(filteredProducts, category);
        }
        if (color != null && !color.isEmpty()) {
            filteredProducts = filterByColor(filteredProducts, color);
        }
        if (minPrice != null && maxPrice != null) {
            filteredProducts = filterByPriceRange(filteredProducts, minPrice, maxPrice);
        }
        if (minRating >= 0) {
            filteredProducts = filterByRating(filteredProducts, minRating);
        }

        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity p : filteredProducts) {
            double averageRating = p.calculateAverageRating();
            ProductDTO productDTO = ProductMappers.toDTO(p);
            productDTO.setAverageRating(averageRating);

            productDTO.setProductStockStatus(p.getProductStockStatus());
            productDTO.setProductStatus(p.getProductStatus());

            dtoList.add(productDTO);
        }
        return dtoList;
    }



    public static List<ProductEntity> filterByGender(List<ProductEntity> products, String gender) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        for (ProductEntity product : products) {
            if (product.getProductGender().equalsIgnoreCase(gender)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<ProductEntity> filterByCategory(List<ProductEntity> products, String category) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        for (ProductEntity product : products) {
            if (product.getProductCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<ProductEntity> filterByColor(List<ProductEntity> products, String color) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        for (ProductEntity product : products) {
            if (product.getProductColor().equalsIgnoreCase(color)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<ProductEntity> filterByPriceRange(List<ProductEntity> products, BigDecimal minPrice, BigDecimal maxPrice) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        for (ProductEntity product : products) {
            BigDecimal price = product.getProductRegularPrice();
            if (price.compareTo(minPrice) >= 0 && price.compareTo(maxPrice) <= 0) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static List<ProductEntity> filterByRating(List<ProductEntity> products, double minRating) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        for (ProductEntity product : products) {
            if (product.calculateAverageRating() >= minRating) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

/*
    filterby gender, category, color, price, rating+
    productStatus create Enum+
    if have sale price set SALE+
    if it is new set NEW ARRIVAL+
    getRecipe
 */


}
