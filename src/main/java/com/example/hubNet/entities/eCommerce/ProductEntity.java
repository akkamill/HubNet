package com.example.hubNet.entities.eCommerce;

import com.example.hubNet.entities.eCommerce.enums.ProductSaleStatus;
import com.example.hubNet.entities.eCommerce.enums.ProductStatus;
import com.example.hubNet.entities.eCommerce.enums.ProductStockStatus;
import com.example.hubNet.entities.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productDescription;
    private String productCategory;
    private BigDecimal productRegularPrice;
    private BigDecimal productSalePrice;
    private Long productInStock;
    private String productColor;
    private String productGender;
    private String productSize;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @Enumerated(EnumType.STRING)
    private ProductStockStatus productStockStatus;

    @Enumerated(EnumType.STRING)
    private ProductSaleStatus productSaleStatus;

    @Transient
    private MultipartFile productImage;
    private String productImagePath;

    @CreationTimestamp
    private LocalDateTime productCreatedAt;

    @ManyToOne
    @JoinColumn(name = "product_user")
    private UserEntity productUser;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ReviewEntity> reviews = new ArrayList<>();



    public double calculateAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }

        int totalRating = 0;
        for (ReviewEntity review : reviews) {
            totalRating += review.getRate();
        }

        return (double) totalRating / reviews.size();
    }


}
