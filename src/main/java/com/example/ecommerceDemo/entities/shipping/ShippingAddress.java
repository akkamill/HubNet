    package com.example.ecommerceDemo.entities.shipping;

    import com.example.ecommerceDemo.entities.UserEntity;
    import jakarta.persistence.*;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;

    import java.time.LocalDateTime;

    @Data
    @Entity
    public class ShippingAddress {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long shippingId;

        private String shippingName;
        private String shippingLastName;
        private String shippingEmail;
        private boolean emailNews;
        private String shippingAddress;
        private String shippingDoorNo;
        private String shippingCountry;
        private String shippingCity;
        private String shippingState;
        private String shippingZipCode;
        private String shippingMobNumber;
        private boolean textNews;

        @CreationTimestamp
        private LocalDateTime creationAt;

//        @ManyToOne
//        @JoinColumn(name = "user_id")
//        private UserEntity user;

    }
