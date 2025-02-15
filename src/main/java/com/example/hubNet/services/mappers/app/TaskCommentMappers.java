package com.example.hubNet.services.mappers.app;


import com.example.hubNet.DTO.app.TaskCommentDTO;
import com.example.hubNet.DTO.app.TaskDTO;
import com.example.hubNet.entities.app.TaskCommentEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskCommentMappers {


    public static TaskCommentDTO toDTO(TaskCommentEntity taskCommentEntity) {
        TaskCommentDTO taskCommentDTO = new TaskCommentDTO();
        taskCommentDTO.setTaskCommentId(taskCommentEntity.getTaskCommentId());
        taskCommentDTO.setCommentText(taskCommentEntity.getCommentText());

//        taskCommentDTO.setTask(TaskMappers.toDTO(taskCommentEntity.getTask()));

        if (taskCommentEntity.getTask() != null) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTaskId(taskCommentEntity.getTask().getTaskId());
            // Set other task properties here
            taskCommentDTO.setTask(taskDTO);
        }

        taskCommentDTO.setTaskCommentUser(UserMappers.toDTO(taskCommentEntity.getTaskCommentUser()));

        return taskCommentDTO;
    }

    public static TaskCommentEntity toEntity(TaskCommentDTO taskCommentDTO) {
        TaskCommentEntity taskCommentEntity = new TaskCommentEntity();
        taskCommentEntity.setTaskCommentId(taskCommentDTO.getTaskCommentId());
        taskCommentEntity.setCommentText(taskCommentDTO.getCommentText());

        if(taskCommentDTO.getTask() != null) {
            taskCommentEntity.setTask(TaskMappers.toEntity(taskCommentDTO.getTask()));
        } else {
            taskCommentEntity.setTask(null);
        }
        taskCommentEntity.setTaskCommentUser(UserMappers.toEntity(taskCommentDTO.getTaskCommentUser()));

        return taskCommentEntity;
    }

    public static List<TaskCommentEntity> toEntityList(List<TaskCommentDTO> taskCommentDTOList) {
        if (taskCommentDTOList == null) {
            return Collections.emptyList(); // or new ArrayList<>()
        }
        return taskCommentDTOList.stream().map(TaskCommentMappers::toEntity).collect(Collectors.toList());
    }

    public static List<TaskCommentDTO> toDTOList(List<TaskCommentEntity> taskCommentEntityList) {
        if(taskCommentEntityList == null) {
            return Collections.emptyList();
        }
        return taskCommentEntityList.stream().map(TaskCommentMappers::toDTO).collect(Collectors.toList());
    }

}
