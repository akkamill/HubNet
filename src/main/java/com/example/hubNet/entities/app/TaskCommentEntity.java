package com.example.hubNet.entities.app;

import com.example.hubNet.entities.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task_comment")
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
