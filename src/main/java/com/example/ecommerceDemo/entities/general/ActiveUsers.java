package com.example.ecommerceDemo.entities.general;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class ActiveUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activeUserId;

    @UpdateTimestamp
    private LocalDateTime lastSeen;

}

