package com.example.hubNet.controllers.app;

import com.example.hubNet.DTO.app.TaskCommentDTO;
import com.example.hubNet.services.app.TaskCommentService;
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
