package com.example.hubNet.repositories.app;

import com.example.hubNet.entities.app.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

//    List<ChatEntity> findBySenderAndRecipient(String sender, String recipient);
}
