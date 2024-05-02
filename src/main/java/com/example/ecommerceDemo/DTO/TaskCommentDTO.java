    package com.example.ecommerceDemo.DTO;

    import com.example.ecommerceDemo.entities.UserEntity;
    import com.example.ecommerceDemo.entities.app.TaskEntity;
    import jakarta.persistence.*;
    import lombok.Data;

    @Data
    public class TaskCommentDTO {

        private Long taskCommentId;
        private String commentText;
        private TaskDTO task;
        private UserDTO taskCommentUser;

    }
