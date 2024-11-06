package com.example.ecommerceDemo.entities.general.application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "application")
@Data
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    private String name;
    private String platform;
    private int price;


    @OneToMany(mappedBy = "applicationEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AppRatings> appRatings = new ArrayList<>();


    public double calculateAverageRating() {
        if (appRatings.isEmpty()) {
            return 0;
        }

        int totalRating = 0;
        for (AppRatings review : appRatings) {
            totalRating += review.getRate();
        }

        return (double) totalRating / appRatings.size();
    }

}
