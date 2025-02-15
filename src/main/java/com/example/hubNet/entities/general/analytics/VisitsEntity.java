    package com.example.hubNet.entities.general.analytics;

    import com.example.hubNet.entities.user.UserEntity;
    import jakarta.persistence.*;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;

    import java.time.LocalDateTime;

    @Entity(name = "visits")
    @Data
    public class VisitsEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long visitId;

        private String visitCountry;
        private int websiteVisits;

        @CreationTimestamp
        private LocalDateTime visitDate;

        @ManyToOne
        private UserEntity user;
    }
