package com.example.ecommerceDemo.controllers;

import com.example.ecommerceDemo.DTO.EmailDTO;
import com.example.ecommerceDemo.services.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
    }
}
