package com.example.ecommerceDemo.entities.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SocialMediaLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socialMediaId;

    private String platform;
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;
}
