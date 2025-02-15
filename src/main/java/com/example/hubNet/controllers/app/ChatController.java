package com.example.hubNet.controllers.app;

import com.example.hubNet.DTO.app.ChatDTO;
import com.example.hubNet.services.app.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send/{userId}")
    public ResponseEntity<String> sendMessage(@PathVariable Long userId,
                                              @ModelAttribute ChatDTO chatDTO) {
        try {
            chatService.sendMessage(userId, chatDTO);
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
