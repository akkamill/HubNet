package com.example.ecommerceDemo.entities.general.analytics;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "news_updates")
@Data
public class NewsUpdatesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subtitle;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private UserEntity user;

}
