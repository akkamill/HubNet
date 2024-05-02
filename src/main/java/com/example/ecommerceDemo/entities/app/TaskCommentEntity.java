package com.example.ecommerceDemo.entities.app;

import com.example.ecommerceDemo.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskCommentId;

    private String commentText;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity taskCommentUser;

}
