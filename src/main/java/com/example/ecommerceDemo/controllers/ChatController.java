package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.ChatDTO;
import com.example.ecommerceDemo.services.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@ModelAttribute ChatDTO chatDTO) {
        try {
            chatService.sendMessage(chatDTO);
            return ResponseEntity.ok("Message sent successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message " + e.getMessage());
        }
    }

    @PostMapping("/attach-files/{chatId}")
    public ResponseEntity<?> sendAttachment(@PathVariable Long chatId,
                                            @RequestParam("file") MultipartFile file) {
        try {
            ChatDTO chatDTO = chatService.attachFiles(chatId, file);
            return ResponseEntity.ok(chatDTO);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send attachment: " + e.getMessage());
        }
    }

    @PostMapping("/send-voice-message/{chatId}")
    public ResponseEntity<?> sendVoiceMessage(@PathVariable Long chatId,
                                              @RequestParam("voiceMessage") MultipartFile voiceMessage) {
        try {
            ChatDTO chatDTO = chatService.sendVoiceMessage(chatId, voiceMessage);
            return ResponseEntity.ok(chatDTO);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send voice message: " + e.getMessage());
        }
    }


//    @GetMapping("/get")
//    public ResponseEntity<List<ChatEntity>> getMessage(@RequestParam String sender,
//                                                       @RequestParam String recipient) {
//        List<ChatEntity> messages = chatService.getMessages(sender, recipient);
//
//        return ResponseEntity.ok(messages);
//    }

}
