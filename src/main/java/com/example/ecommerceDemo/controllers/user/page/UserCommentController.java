package com.example.ecommerceDemo.controllers.user.page;

import com.example.ecommerceDemo.DTO.user.page.UserCommentDTO;
import com.example.ecommerceDemo.services.user.page.UserCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user-comments")
public class UserCommentController {

    private final UserCommentService userCommentService;

    public UserCommentController(UserCommentService userCommentService) {
        this.userCommentService = userCommentService;
    }


    @PostMapping("/create/{userId}")
    public ResponseEntity<UserCommentDTO> createComment(@PathVariable Long userId,
                                                        @RequestParam String commentText,
                                                        @RequestParam(value = "commentImage", required = false) MultipartFile commentImage) throws IOException {
        UserCommentDTO userCommentDTO = new UserCommentDTO();
        userCommentDTO.setCommentText(commentText);

        UserCommentDTO createdComment = userCommentService.createComment(userId, userCommentDTO, commentImage);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<UserCommentDTO> updateComment(@PathVariable Long commentId,
                                                        @RequestBody UserCommentDTO userCommentDTO) {
        try {
            UserCommentDTO updatedComment = userCommentService.updateComment(commentId, userCommentDTO);
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserCommentDTO>> getAllComments() {
        List<UserCommentDTO> comments = userCommentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        try {
            userCommentService.deleteComment(commentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
