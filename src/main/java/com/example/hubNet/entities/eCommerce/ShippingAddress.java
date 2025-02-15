    package com.example.hubNet.entities.eCommerce;

    import com.example.hubNet.entities.user.UserEntity;
    import jakarta.persistence.*;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;

    import java.time.LocalDateTime;

    @Data
    @Entity
    @Table(name = "shipping_address")
    public class ShippingAddress {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long shippingId;

        private String shippingName;
        private String shippingLastName;
        private String shippingEmail;
        private String shippingAddress;
        private String shippingDoorNo;
        private String shippingCountry;
        private String shippingCity;
        private String shippingState;
        private String shippingZipCode;
        private String shippingMobNumber;
        private boolean emailNews;
        private boolean textNews;

        @CreationTimestamp
        private LocalDateTime creationAt;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity user;

    }
