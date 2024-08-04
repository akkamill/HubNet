package com.example.ecommerceDemo.DTO.eCommerce;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import com.example.ecommerceDemo.entities.eCommerce.enums.ProductSaleStatus;
import com.example.ecommerceDemo.entities.eCommerce.enums.ProductStatus;
import com.example.ecommerceDemo.entities.eCommerce.enums.ProductStockStatus;
import jakarta.persistence.Transient;
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
    private ProductStatus productStatus;
    private ProductSaleStatus productSaleStatus;
    private ProductStockStatus productStockStatus;


    @Transient
    private MultipartFile productImage;
    private String productImagePath;

    private LocalDateTime productCreatedAt;

    private UserDTO userDTO;
    private List<ReviewDTO> reviews;

}
