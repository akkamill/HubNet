package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.TaskCommentDTO;
import com.example.ecommerceDemo.services.TaskCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taskComments")
public class TaskCommentController {

    private final TaskCommentService  taskCommentService;

    public TaskCommentController(TaskCommentService taskCommentService) {
        this.taskCommentService = taskCommentService;
    }

    @PostMapping("/create/{taskId}")
    public ResponseEntity<TaskCommentDTO> createTaskComment(@PathVariable Long taskId,
                                                            @RequestBody TaskCommentDTO taskCommentDTO) {
        TaskCommentDTO createdTaskComment = taskCommentService.createTaskComment(taskId, taskCommentDTO);
        return new ResponseEntity<>(createdTaskComment, HttpStatus.CREATED);
    }

}
