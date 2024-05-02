package com.example.ecommerceDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Transient
    private MultipartFile productImage;
    private String productImagePath;

    @CreationTimestamp
    private LocalDateTime productCreatedAt;


    @OneToMany(mappedBy = "product")
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
