package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.EmailDTO;
import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.entities.app.EmailEntity;
import com.example.ecommerceDemo.repositories.EmailRepository;
import com.example.ecommerceDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;


    @Autowired
    public EmailService(EmailRepository emailRepository,
                        JavaMailSender javaMailSender,
                        UserRepository userRepository) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
        this.userRepository = userRepository;
    }

    public void sendEmail(EmailDTO emailDTO) {

        UserEntity sender = userRepository.findByEmailAddress(emailDTO.getSenderEmail()).orElseThrow(()
                -> new RuntimeException("Sender not found"));

        List<UserEntity> recipients = new ArrayList<>();
        for (String recipientEmail : emailDTO.getRecipientEmail()) {
            UserEntity recipient = userRepository.findByEmailAddress(recipientEmail).orElseThrow(()
                    -> new RuntimeException("Recipient not found"));
            recipients.add(recipient);
        }


        for (UserEntity recipient : recipients) {
            EmailEntity email = new EmailEntity();
            email.setSubject(emailDTO.getSubject());
            email.setBody(emailDTO.getBody());
            email.setSenderEmail(sender);
            email.setRecipientEmail(recipient);
            emailRepository.save(email);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(emailDTO.getSubject());
            message.setText(email.getBody());
            message.setFrom(sender.getEmailAddress());
            message.setTo(recipient.getEmailAddress());
            javaMailSender.send(message);

        }
    }


}
