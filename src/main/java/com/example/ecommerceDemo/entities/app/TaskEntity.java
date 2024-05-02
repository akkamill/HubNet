package com.example.ecommerceDemo.entities.app;

import com.example.ecommerceDemo.entities.UserEntity;
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

    private TaskEntity(Builder builder) {
        setTaskId(builder.taskId);
        setTaskName(builder.taskName);
        setTaskDescription(builder.taskDescription);
        setTaskStatus(builder.taskStatus);
        setTaskPrioritization(builder.taskPrioritization);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setTaskImage(builder.taskImage);
        setTaskImagePath(builder.taskImagePath);
        setTaskComments(builder.taskComments);
        setSectionEntity(builder.sectionEntity);
        setAssignedUsers(builder.assignedUsers);
    }


    public static final class Builder {
        private Long taskId;
        private String taskName;
        private String taskDescription;
        private boolean taskStatus;
        private String taskPrioritization;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private MultipartFile taskImage;
        private String taskImagePath;
        private List<TaskCommentEntity> taskComments;
        private SectionEntity sectionEntity;
        private List<UserEntity> assignedUsers;

        public Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder taskId(Long val) {
            taskId = val;
            return this;
        }

        public Builder taskName(String val) {
            taskName = val;
            return this;
        }

        public Builder taskDescription(String val) {
            taskDescription = val;
            return this;
        }

        public Builder taskStatus(boolean val) {
            taskStatus = val;
            return this;
        }

        public Builder taskPrioritization(String val) {
            taskPrioritization = val;
            return this;
        }

        public Builder startTime(LocalDateTime val) {
            startTime = val;
            return this;
        }

        public Builder endTime(LocalDateTime val) {
            endTime = val;
            return this;
        }

        public Builder taskImage(MultipartFile val) {
            taskImage = val;
            return this;
        }

        public Builder taskImagePath(String val) {
            taskImagePath = val;
            return this;
        }

        public Builder taskComments(List<TaskCommentEntity> val) {
            taskComments = val;
            return this;
        }

        public Builder sectionEntity(SectionEntity val) {
            sectionEntity = val;
            return this;
        }

        public Builder assignedUsers(List<UserEntity> val) {
            assignedUsers = val;
            return this;
        }

        public TaskEntity build() {
            return new TaskEntity(this);
        }
    }
}
