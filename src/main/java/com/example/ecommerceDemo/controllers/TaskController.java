package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.TaskDTO;
import com.example.ecommerceDemo.services.TaskService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create/{sectionId}")
    public ResponseEntity<?> createTask(@PathVariable Long sectionId,
                                        @ModelAttribute TaskDTO taskDTO,
                                        @RequestParam(value = "taskImage", required = false)
                                        MultipartFile taskImage) {
        try {
            TaskDTO createdTask = taskService.createTask(sectionId, taskDTO, taskImage);
            return ResponseEntity.ok().body(createdTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/get/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable Long taskId) {
        taskService.getTaskById(taskId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Successfully deleted" + taskId);
    }
}
