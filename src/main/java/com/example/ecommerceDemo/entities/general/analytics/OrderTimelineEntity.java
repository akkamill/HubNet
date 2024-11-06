package com.example.ecommerceDemo.entities.general.analytics;

import com.example.ecommerceDemo.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "order_timeline")
@Data
public class OrderTimelineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderTimelineId;

    private String orderName;

    @ManyToOne
    UserEntity user;

    @CreationTimestamp
    private LocalDateTime orderTime;
}
