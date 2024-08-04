package com.example.ecommerceDemo.services.app;

import com.example.ecommerceDemo.DTO.app.EmailDTO;
import com.example.ecommerceDemo.entities.app.enums.EmailStatus;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.app.EmailEntity;
import com.example.ecommerceDemo.repositories.app.EmailRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
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

    public void sendEmail(Long senderId, EmailDTO emailDTO) {

        UserEntity sender = userRepository.findById(senderId).orElseThrow(()
                -> new RuntimeException("Sender not found"));

        List<UserEntity> recipients = new ArrayList<>();
        for (String recipientEmail : emailDTO.getRecipientEmailAddresses()) {
            UserEntity recipient = userRepository.findByEmailAddress(recipientEmail).orElseThrow(()
                    -> new RuntimeException("Recipient not found"));
            recipients.add(recipient);
        }

        for (UserEntity recipient : recipients) {
            EmailEntity email = new EmailEntity();
            email.setSubject(emailDTO.getSubject());
            email.setBody(emailDTO.getBody());
            email.setEmailStatus(EmailStatus.SENT);
            email.setDraft(false);
            email.setImportant(false);
            email.setRead(false);
            email.setSenderEmail(sender);
            email.setRecipientEmail(recipients);
            emailRepository.save(email);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(emailDTO.getSubject());
            message.setText(email.getBody());
            message.setFrom(sender.getEmailAddress());
            message.setTo(recipient.getEmailAddress());
            javaMailSender.send(message);

        }
    }

    public EmailEntity getEmail(Long emailId) {
        return emailRepository.findById(emailId).orElseThrow(() ->
                new RuntimeException("Email not found"));
    }

    public List<EmailEntity> getAllEmails() {
        List<EmailEntity> emails = emailRepository.findAll();

        for (EmailEntity entities : emails) {
            if (entities.getEmailStatus() == null) {
                entities.setEmailStatus(EmailStatus.INBOX);
                emailRepository.save(entities);
            }
        }
        return emails;
    }

    public List<EmailEntity> getEmailsByStatus(EmailStatus status) {
        return emailRepository.findByEmailStatus(status);
    }

    public void deleteEmail(Long emailId) {
        EmailEntity email = emailRepository.findById(emailId).orElseThrow(()
                -> new RuntimeException("Email not found"));
        emailRepository.deleteById(emailId);
        email.setEmailStatus(EmailStatus.TRASH);
    }

    public void toDraft(Long emailId) {
        EmailEntity email = emailRepository.findById(emailId).orElseThrow(()
                -> new RuntimeException("Email not found"));
        email.setDraft(true);
        email.setEmailStatus(EmailStatus.DRAFT);
        emailRepository.save(email);

    }

    public void toImportant(Long emailId) {
        EmailEntity email = emailRepository.findById(emailId).orElseThrow(()
                -> new RuntimeException("Email not found"));
        email.setImportant(true);
        email.setEmailStatus(EmailStatus.IMPORTANT);
        emailRepository.save(email);
    }

    public void toSpam(Long emailId) {
        EmailEntity email = emailRepository.findById(emailId).orElseThrow(()
                -> new RuntimeException("Email not found"));
        email.setEmailStatus(EmailStatus.SPAM);
        emailRepository.save(email);
    }

    public void markAsRead(Long emailId) {
        EmailEntity email = emailRepository.findById(emailId).orElseThrow(()
                -> new RuntimeException("Email not found"));
        email.setRead(true);
        emailRepository.save(email);
    }




}
