package com.example.ecommerceDemo.DTO;

import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ChatDTO {

    private Long id;
    private Long senderChatId;
    private List<Long> recipientChatId;
    private String chatText;
    private LocalDateTime createdAt;

    @Transient
    private MultipartFile attachFile;
    private String attachFilePath;

    @Transient
    private MultipartFile voiceMessage;
    private String voiceMessagePath;
}
