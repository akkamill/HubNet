package com.example.hubNet.services.mappers.eCommerce;

import com.example.hubNet.DTO.eCommerce.ProductDTO;
import com.example.hubNet.DTO.eCommerce.ReviewDTO;
import com.example.hubNet.entities.eCommerce.ProductEntity;
import com.example.hubNet.entities.eCommerce.ReviewEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMappers {


    public static ProductEntity toEntity(ProductDTO productDTO) {
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
        productEntity.setProductStatus(productDTO.getProductStatus());
        productDTO.setProductSaleStatus(productDTO.getProductSaleStatus());
        productDTO.setProductStockStatus(productDTO.getProductStockStatus());

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


    public static ProductDTO toDTO(ProductEntity productEntity) {
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
        productDTO.setProductStatus(productEntity.getProductStatus());
        productDTO.setProductSaleStatus(productEntity.getProductSaleStatus());
        productDTO.setProductStockStatus(productEntity.getProductStockStatus());

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
