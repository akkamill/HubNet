package com.example.ecommerceDemo.DTO.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

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

    private List<TaskCommentDTO> taskComments;
    private SectionDTO sectionDTO;
    private List<Long> assignedUsers;
}


