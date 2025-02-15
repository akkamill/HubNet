package com.example.hubNet.services.mappers.app;


import com.example.hubNet.DTO.app.ChatDTO;
import com.example.hubNet.DTO.user.UserDTO;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.entities.app.ChatEntity;
import com.example.hubNet.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ChatMappers {


    public static ChatDTO toDTO(ChatEntity chatEntity) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setId(chatEntity.getId());
        chatDTO.setChatText(chatEntity.getChatText());
        chatDTO.setCreatedAt(chatEntity.getCreatedAt());
        chatDTO.setAttachFilePath(chatEntity.getAttachFilePath());
        chatDTO.setVoiceMessagePath(chatEntity.getVoiceMessagePath());

        if (chatEntity.getSenderChat() != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(chatEntity.getSenderChat().getUserId());
        }

        chatDTO.setRecipientChatId(chatEntity.getRecipientChat()
                .stream()
                .map(UserEntity::getUserId)
                .collect(Collectors.toList()));
        return chatDTO;
    }

    public static ChatEntity toEntity(ChatDTO dto) {
        ChatEntity entity = new ChatEntity();

        entity.setId(dto.getId());
        entity.setSenderChat(UserMappers.toEntity(dto.getSenderChatId()));
        // Since sender and recipients are not part of DTO, they won't be mapped here
        entity.setChatText(dto.getChatText());
        entity.setAttachFilePath(dto.getAttachFilePath());
        entity.setVoiceMessagePath(dto.getVoiceMessagePath());
        return entity;

    }
}
