package com.example.ecommerceDemo.entities.general.application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class AppRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appRatingId;

    private String appReviewText;
    private int rate;

    @CreationTimestamp
    private LocalDateTime rateCreatedAt;


    @ManyToOne
    @JoinColumn(name = "application_id")
    @JsonIgnore
    private ApplicationEntity applicationEntity;





}
