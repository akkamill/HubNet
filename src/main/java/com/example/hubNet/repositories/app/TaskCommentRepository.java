package com.example.hubNet.repositories.app;

import com.example.hubNet.entities.app.TaskCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCommentRepository extends JpaRepository<TaskCommentEntity, Long> {

}
