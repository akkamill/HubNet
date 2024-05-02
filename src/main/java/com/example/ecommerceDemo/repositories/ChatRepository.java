package com.example.ecommerceDemo.repositories;

import com.example.ecommerceDemo.entities.app.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

//    List<ChatEntity> findBySenderAndRecipient(String sender, String recipient);
}
