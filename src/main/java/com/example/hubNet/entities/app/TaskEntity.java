package com.example.hubNet.entities.app;

import com.example.hubNet.entities.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;
    private String taskDescription;
    private boolean taskStatus;
    private String taskPrioritization;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Transient
    @JsonIgnore
    private MultipartFile taskImage;
    private String taskImagePath;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<TaskCommentEntity> taskComments;


    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity sectionEntity;

    @ManyToMany
    @JoinTable(
            name = "task_assigned_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> assignedUsers;

}
