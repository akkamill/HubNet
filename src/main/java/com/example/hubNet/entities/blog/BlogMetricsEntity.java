package com.example.hubNet.entities.blog;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blog_metrics")
public class BlogMetricsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metricsId;

    private int viewCount;
    private int shareCount;

    @OneToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "blogId")
    private BlogEntity blog;
}
