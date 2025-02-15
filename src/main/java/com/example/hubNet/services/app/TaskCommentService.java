package com.example.hubNet.services.app;

import com.example.hubNet.DTO.app.TaskCommentDTO;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.app.TaskCommentEntity;
import com.example.hubNet.entities.app.TaskEntity;
import com.example.hubNet.repositories.app.TaskCommentRepository;
import com.example.hubNet.repositories.app.TaskRepository;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.services.mappers.app.TaskCommentMappers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TaskCommentService {

    private final TaskCommentRepository taskCommentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskCommentService(TaskCommentRepository taskCommentRepository,
                              TaskRepository taskRepository, UserRepository userRepository) {
        this.taskCommentRepository = taskCommentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TaskCommentDTO createTaskComment(Long taskId, TaskCommentDTO taskCommentDTO) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() ->
                new RuntimeException("Task not found"));

        TaskCommentEntity taskCommentEntity = TaskCommentMappers.toEntity(taskCommentDTO);

        if (taskCommentDTO.getTaskCommentUser() != null && taskCommentDTO.getTaskCommentUser().getUserId() != null) {
            UserEntity userEntity = userRepository.findById(taskCommentDTO.getTaskCommentUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            taskCommentEntity.setTaskCommentUser(userEntity);
        }
        taskCommentEntity.setTask(taskEntity);

        taskCommentEntity = taskCommentRepository.save(taskCommentEntity);

        return TaskCommentMappers.toDTO(taskCommentEntity);

    }

//-------------------------------------------------------------------------------------------------------------------//

}
