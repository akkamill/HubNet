package com.example.hubNet.entities.app;

import com.example.hubNet.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "sections")
@NoArgsConstructor
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    private String sectionName;

    @OneToMany(mappedBy = "sectionEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
