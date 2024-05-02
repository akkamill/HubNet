package com.example.ecommerceDemo.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long productId;
    private String productName;
    private String productDescription;
    private String productCategory;
    private BigDecimal productRegularPrice;
    private BigDecimal productSalePrice;
    private Long productInStock;
    private double averageRating;
    private String productColor;
    private String productGender;
    private String productSize;

    @Transient
    private MultipartFile productImage;
    private String productImagePath;

    private LocalDateTime productCreatedAt;

    private List<ReviewDTO> reviews;

}
