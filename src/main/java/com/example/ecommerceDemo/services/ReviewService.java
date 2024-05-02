package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.ReviewDTO;
import com.example.ecommerceDemo.entities.ProductEntity;
import com.example.ecommerceDemo.entities.ReviewEntity;
import com.example.ecommerceDemo.repositories.ProductRepository;
import com.example.ecommerceDemo.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public ReviewDTO createReview(Long id, ReviewDTO reviewDTO) {

        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found"));

        ReviewEntity reviewEntity = toEntity(reviewDTO);
        reviewEntity.setProduct(productEntity);
        reviewRepository.save(reviewEntity);

        productEntity.getReviews().add(reviewEntity);


        return toDTO(reviewEntity);
    }


    // --------------------------------------------------------------------------------------------------------------//

    public ReviewEntity toEntity(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = new ReviewEntity();

        reviewEntity.setReviewId(reviewDTO.getReviewId());
        reviewEntity.setRate(reviewDTO.getRate());
        reviewEntity.setReviewEmail(reviewDTO.getReviewEmail());
        reviewEntity.setReviewName(reviewDTO.getReviewName());
        reviewEntity.setReviewText(reviewDTO.getReviewText());
        reviewEntity.setReviewCreatedAt(reviewDTO.getReviewCreatedAt());

        if (reviewDTO.getProduct() != null) {
            reviewEntity.setProduct(productService.toEntity(reviewDTO.getProduct()));
        }

        return reviewEntity;
    }

    public ReviewDTO toDTO(ReviewEntity reviewEntity) {
        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setReviewId(reviewEntity.getReviewId());
        reviewDTO.setRate(reviewEntity.getRate());
        reviewDTO.setReviewEmail(reviewEntity.getReviewEmail());
        reviewDTO.setReviewName(reviewEntity.getReviewName());
        reviewDTO.setReviewText(reviewEntity.getReviewText());
        reviewDTO.setReviewCreatedAt(reviewEntity.getReviewCreatedAt());

        if (reviewEntity.getProduct() != null) {
            reviewDTO.setProduct(productService.toDTO(reviewEntity.getProduct()));
        }

        return reviewDTO;
    }


}
