    package com.example.ecommerceDemo.DTO.app;

    import com.example.ecommerceDemo.DTO.user.UserDTO;
    import lombok.Data;

    @Data
    public class TaskCommentDTO {

        private Long taskCommentId;
        private String commentText;
        private TaskDTO task;
        private UserDTO taskCommentUser;

    }
