package com.example.ecommerceDemo.entities.home;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "support")
public class SupportEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long supportId;

    private String name;
    private String email;
    private String subject;
    @Lob
    private String message;
}
