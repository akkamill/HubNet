package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long reviewId;
    private int rate;
    private String reviewText;
    private String reviewName;
    private String reviewEmail;

    private ProductDTO product;

    private LocalDateTime reviewCreatedAt;

}
