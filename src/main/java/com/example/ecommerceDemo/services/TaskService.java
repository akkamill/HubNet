package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.TaskDTO;
import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.entities.app.SectionEntity;
import com.example.ecommerceDemo.entities.app.TaskEntity;
import com.example.ecommerceDemo.repositories.SectionRepository;
import com.example.ecommerceDemo.repositories.TaskRepository;
import com.example.ecommerceDemo.repositories.UserRepository;
import com.example.ecommerceDemo.services.mappers.TaskMappers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final SectionRepository sectionRepository;
    private final UserRepository userRepository;


    public TaskService(TaskRepository taskRepository, SectionRepository sectionRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.sectionRepository = sectionRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TaskDTO createTask(Long sectionId, TaskDTO taskDTO, MultipartFile taskImage) throws IOException {

        SectionEntity sectionEntity = sectionRepository.findById(sectionId).orElseThrow(()
                -> new RuntimeException("Section not found"));

        TaskEntity taskEntity = TaskMappers.toEntity(taskDTO);

        taskEntity.setSectionEntity(sectionEntity);

//---------------------------------------------ADDING PHOTO---------------------------------------------------------//

        if (taskImage != null && !taskImage.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\taskPhotos\\";

            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            String filePath = uploadDir + taskEntity.getTaskId() + "_" + taskImage.getOriginalFilename();

            Path blogPhotoPath = Paths.get(filePath);
            Files.write(blogPhotoPath, taskImage.getBytes());

            taskEntity.setTaskImagePath(filePath);
        }
//------------------------------------------------------------------------------------------------------------------//

        if (taskDTO.getAssignedUsers() != null && !taskDTO.getAssignedUsers().isEmpty()) {
            List<UserEntity> assignedUsers = new ArrayList<>();
            for (Long userId : taskDTO.getAssignedUsers()) {
                UserEntity user = userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found" + userId));
                assignedUsers.add(user);
            }
            taskEntity.setAssignedUsers(assignedUsers);
        }

        sectionEntity.getTasks().add(taskEntity);
        sectionRepository.save(sectionEntity);

        return TaskMappers.toDTO(taskEntity);
    }

    @Transactional
    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> entities = taskRepository.findAll();
        List<TaskDTO> dtoList = new ArrayList<>();
        for (TaskEntity t : entities) {
            TaskDTO taskDTO = TaskMappers.toDTO(t);
            dtoList.add(taskDTO);
        }
        return dtoList;
    }

    @Transactional
    public TaskDTO getTaskById(Long taskId) {
        Optional<TaskEntity> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            return TaskMappers.toDTO(taskOptional.get());
        } else {
            throw new RuntimeException("Task not found with ID: " + taskId);
        }
    }

    @Transactional
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }


    //---------------------------------------------------------------------------------------------------------------//


}
