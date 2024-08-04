package com.example.ecommerceDemo.services.app;

import com.example.ecommerceDemo.DTO.app.ChatDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.app.ChatEntity;
import com.example.ecommerceDemo.repositories.app.ChatRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.services.mappers.app.ChatMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
//    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatService(ChatRepository chatRepository,
                       UserRepository userRepository) {
//                       SimpMessagingTemplate messagingTemplate) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
//        this.messagingTemplate = messagingTemplate;
    }

    @Transactional
    public void sendMessage(Long userId, ChatDTO chatDTO) {

        UserEntity sender = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("Sender not found"));

        List<UserEntity> recipients = new ArrayList<>();
        for (Long recipientChatId : chatDTO.getRecipientChatId()) {
            UserEntity recipient = userRepository.findById(recipientChatId).orElseThrow(()
                    -> new RuntimeException("Recipient not found"));
            recipients.add(recipient);
        }

        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setChatText(chatDTO.getChatText());
        chatEntity.setSenderChat(sender);
        chatEntity.setRecipientChat(recipients);
        chatEntity.setCreatedAt(LocalDateTime.now());

        chatRepository.save(chatEntity);

//        recipients.forEach(recipient -> messagingTemplate.convertAndSendToUser(recipient.getEmailAddress(),
//                "/queue/messages", chatEntity));
    }


    @Transactional
    public ChatDTO sendVoiceMessage(Long chatId, MultipartFile voiceMessage) throws IOException {

        ChatEntity chatEntity = chatRepository.findById(chatId).orElseThrow(()
                -> new RuntimeException("Chat not found"));


        if (voiceMessage != null && !voiceMessage.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommerce\\src\\main\\resources\\voiceMessages\\";

            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            String filePath = uploadDir + chatEntity.getId() + "_" + voiceMessage.getOriginalFilename();

            Path voiceMessagePath = Paths.get(filePath);
            Files.write(voiceMessagePath, voiceMessage.getBytes());

            chatEntity.setVoiceMessagePath(filePath);

            chatRepository.save(chatEntity);
        }
        return ChatMappers.toDTO(chatEntity);
    }

    @Transactional
    public ChatDTO attachFiles(Long chatId, MultipartFile attachFiles) throws IOException {

        ChatEntity chatEntity = chatRepository.findById(chatId).orElseThrow(()
                -> new RuntimeException("Chat not found"));



        if (attachFiles != null && !attachFiles.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\attachedFiles\\";

            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            String filePath = uploadDir + chatEntity.getId() + "_" + attachFiles.getOriginalFilename();

            Path attachFilesPath = Paths.get(filePath);
            Files.write(attachFilesPath, attachFiles.getBytes());

            chatEntity.setAttachFilePath(filePath);

            chatRepository.save(chatEntity);
        }
        return ChatMappers.toDTO(chatEntity);
    }

}