package com.example.ecommerceDemo.entities.app;

import com.example.ecommerceDemo.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    private String subject;
    private String body;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity senderEmail;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private UserEntity recipientEmail;

    @Transient
    private MultipartFile attachment;
    private String attachmentPath;

}
