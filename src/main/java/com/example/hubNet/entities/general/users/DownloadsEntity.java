    package com.example.hubNet.entities.general.users;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;

    @Entity(name = "downloads")
    @Data
    public class DownloadsEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long downloadId;

        private BigDecimal totalDownloads;
        private String platforms;

        @CreationTimestamp
        private LocalDateTime createdAt;
    }
