package com.example.hubNet.entities.general.analytics;

import com.example.hubNet.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "conversions")
@Data
public class ConversionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversionId;

    private int conversionRates;

    @CreationTimestamp
    private LocalDateTime conversionDate;

    @ManyToOne
    private UserEntity user;
}
