package com.example.hubNet.controllers.app;

import com.example.hubNet.DTO.app.EmailDTO;
import com.example.hubNet.entities.app.EmailEntity;
import com.example.hubNet.entities.app.enums.EmailStatus;
import com.example.hubNet.services.app.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email/{userId}")
    public void sendEmail(@PathVariable Long userId,
                          @RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(userId, emailDTO);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<EmailEntity> getEmail(@PathVariable Long emailId) {
        try {
            EmailEntity email = emailService.getEmail(emailId);
            return ResponseEntity.ok(email);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EmailEntity>> getAllEmails() {
        List<EmailEntity> emails = emailService.getAllEmails();
        return ResponseEntity.ok(emails);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<EmailEntity>> getEmailsByStatus(@PathVariable EmailStatus status) {
        List<EmailEntity> emails = emailService.getEmailsByStatus(status);
        return ResponseEntity.ok(emails);
    }

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long emailId) {
        try {
            emailService.deleteEmail(emailId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{emailId}/draft")
    public ResponseEntity<Void> toDraft(@PathVariable Long emailId) {
        try {
            emailService.toDraft(emailId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/important/{emailId}")
    public ResponseEntity<Void> toImportant(@PathVariable Long emailId) {
        try {
            emailService.toImportant(emailId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/spam/{emailId}")
    public ResponseEntity<Void> toSpam(@PathVariable Long emailId) {
        try {
            emailService.toSpam(emailId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/read/{emailId}")
    public ResponseEntity<Void> markAsRead(@PathVariable Long emailId) {
        try {
            emailService.markAsRead(emailId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
