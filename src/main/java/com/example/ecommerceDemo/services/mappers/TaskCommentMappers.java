package com.example.ecommerceDemo.services.mappers;


import com.example.ecommerceDemo.DTO.TaskCommentDTO;
import com.example.ecommerceDemo.DTO.TaskDTO;
import com.example.ecommerceDemo.entities.app.TaskCommentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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

}
