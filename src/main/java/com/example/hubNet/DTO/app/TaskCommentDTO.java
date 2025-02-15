    package com.example.hubNet.DTO.app;

    import com.example.hubNet.DTO.user.UserDTO;
    import lombok.Data;

    @Data
    public class TaskCommentDTO {

        private Long taskCommentId;
        private String commentText;
        private TaskDTO task;
        private UserDTO taskCommentUser;

    }
