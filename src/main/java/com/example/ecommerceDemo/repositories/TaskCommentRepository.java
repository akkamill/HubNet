package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.app.TaskCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCommentRepository extends JpaRepository<TaskCommentEntity, Long> {

}
