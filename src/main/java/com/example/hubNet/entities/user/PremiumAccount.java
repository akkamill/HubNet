package com.example.hubNet.entities.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "premium_accounts")
public class PremiumAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDateTime activationDate;
    private LocalDateTime expirationDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
