package com.example.hubNet.controllers.blog;

import com.example.hubNet.DTO.blog.CommentDTO;
import com.example.hubNet.services.blog.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create-comment/{id}")
    public ResponseEntity<?> createComment(@PathVariable Long id,
                                           @RequestBody CommentDTO commentDTO) {
        commentService.createComment(id, commentDTO);
        return ResponseEntity.ok("Created successfully");
    }
}
