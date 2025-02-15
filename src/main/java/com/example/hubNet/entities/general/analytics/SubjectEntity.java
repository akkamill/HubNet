package com.example.hubNet.entities.general.analytics;

import com.example.hubNet.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "subjects")
@Data
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String subjectName;
    private String series;

    @ManyToOne
    private UserEntity user;
}
